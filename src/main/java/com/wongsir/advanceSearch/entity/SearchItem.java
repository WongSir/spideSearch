package com.wongsir.advanceSearch.entity;

import org.json.JSONObject;

/** 
* @Description: ����ʵ���࣬�����ڷ���������Ľ�� 
* @author hjd
* @date 2017��1��19�� ����9:34:08 
*  
*/
public class SearchItem {
	private String title; //����
	private String content; // ����
	private String url; //��ַ����
	private String searchKey;//�����ؼ���
	
	public SearchItem(){
		
	}
	
	public SearchItem(String title, String url, String content,String searchKey) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.searchKey = searchKey;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public JSONObject toJSON(){
        JSONObject jo=new JSONObject();
        jo.put("title",title);
        jo.put("url",url);
        jo.put("content",content);

        return jo;
    }
	
	@Override
    public String toString() {
       return "TITLE:"+title+"\n"
               +"URL:"+url+"\n"
                +"CONTENT:"+content+"\n";
    }
	
	public static void main(String[] args) {
        System.out.println(new SearchItem("a","b","c","d"));
    }

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
}
