package com.wongsir.advanceSearch.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wongsir.advanceSearch.entity.KeyWord;
import com.wongsir.advanceSearch.entity.SearchItem;
import com.wongsir.advanceSearch.utils.Config;
import com.wongsir.advanceSearch.utils.HttpUtils;
import com.wongsir.advanceSearch.utils.Rule;

/** 
* @Description: TODO 
* @author hjd
* @date 2017��1��19�� ����1:35:52 
*  
*/
@Service
public class SpiderSearch {
	@Autowired
	private AdvanceSearchService advanceSearchService;

    
    /**
     * �����ݹؼ��ֽ�����ȡ��ֱ�ӷ���������ݣ�Ȼ�����ݴ������ݣ��Ա������ѯ
     * @param keyWord �ؼ���
     * @return
     */
    public List<SearchItem> searchByKey(String keyWord) throws UnsupportedEncodingException{
    	String[] enables=Config.defaultRule.enables.toArray(new String[Config.defaultRule.enables.size()]);
//    	String[] enables = {"bing"};
    	int pageTotalNum =10;
		return searchAndStore(keyWord, pageTotalNum, enables);
    	
    }
    
    /**
   	 * 
   	 * @param keyword �ؼ���
   	 * @param pageTotalNum �������淵�ص�ҳ����
   	 * @param engineNames �������棬��Ŀǰ��bing��sougou
   	 * @return
   	 * @throws UnsupportedEncodingException
   	 */
   	public List<SearchItem> searchAndStore(String keyword,int pageTotalNum,String... engineNames) throws UnsupportedEncodingException {
   		List<SearchItem> searchItems = new ArrayList<SearchItem>();
   		SearchItem searchItem = new SearchItem();
   		for(String engineName:engineNames){
//   			searchItem = doSearchAndStore(keyword, pageTotalNum, engineName)
           	searchItems.addAll(doSearchAndStore(keyword, pageTotalNum, engineName));
           }
           
           return searchItems;
       }
    
    /**
     * ��ȡ��������ҳ����,�Լ���ӵ����ݿ�
     * @param keyword
     * @param pageCount
     * @param engineName
     * @return
     * @throws UnsupportedEncodingException
     */
	public List<SearchItem> doSearchAndStore(String keyword,int pageCount,String engineName) throws UnsupportedEncodingException{
			SearchItem searchItem = new SearchItem();
			List<SearchItem> searchItems = new ArrayList<SearchItem>();
			Rule.ExtractRule eRule=Config.defaultRule.getExtractRule(engineName);
	
	        for(int pageNum=1;pageNum<=pageCount;pageNum++){
	            StringBuilder sb=new StringBuilder();
	            int pageCode=pageNum*eRule.pageMulti+eRule.pageOffset;
	            sb.append(eRule.baseURL)
	            .append(eRule.queryParam)
	            .append("=")
	            .append(URLEncoder.encode(keyword,"utf-8"))
	            .append("&")
	            .append(eRule.pageParam)
	            .append("=")
	            .append(pageCode);
	
	            String url=sb.toString();
	            try {
	                Document doc= HttpUtils.fetchDoc(url);
	                Elements itemEls=doc.select(eRule.itemCSS);
	                int resultNum = 0;
	
	                for(Element element: itemEls) {
	                    resultNum++;
	
	                    Element element_a = element.select(eRule.titleCSS).first();
	                    if(element_a == null)
	                        continue;
	                    String title = element_a.text().trim();
	
	                    String link = element_a.attr("href");
	
	                    String content = null;
	                    Element element_p = element.select(eRule.contentCSS).first();
	                    if(element_p == null)
	                        continue;
	                    content = element_p.text().trim();
	
	                    System.out.println(resultNum);
//	                    SearchItem searchItem = new SearchItem(title, link, content);
	                    searchItem.setTitle(title);
	                    searchItem.setContent(content);
	                    searchItem.setUrl(link);
	                    searchItem.setSearchKey(keyword);
	                    
	                    //�˴�������ݿ���ز���
	                    advanceSearchService.addSearchItem(searchItem);
	                    
	                    System.out.println(searchItem);
	                    searchItems.add(searchItem);
	                    
	                }
	            } catch (Exception e) {
	            	System.out.println(e.getMessage());
	                e.printStackTrace();
	            }
	        }
	        
	        //�ؼ���ֻ�洢һ��
	        if(advanceSearchService.findKey(keyword)!=null){
	        	return searchItems;
	        }
	        
	        KeyWord keyWord = new KeyWord(keyword);
	        advanceSearchService.addKeyWord(keyWord);
	        
			return searchItems;
		}
}
