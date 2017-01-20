package advanceSearch;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wongsir.advanceSearch.App;
import com.wongsir.advanceSearch.entity.SearchItem;
import com.wongsir.advanceSearch.service.AdvanceSearchService;
import com.wongsir.advanceSearch.service.SpiderSearch;

/** 
* @Description: TODO 
* @author hjd
* @date 2017年1月19日 下午7:09:50 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ServiceTest {
	@Autowired
	private AdvanceSearchService advanceSearchService;
	@Autowired
	private SpiderSearch spiderSearch;
	
	@Test
	public void addSearchItem(){
//		SearchItem searchItem = new SearchItem();
//		String title="广州猪肉价格_最新广州猪肉价格/批发报价_广州猪肉价格大全 ...";
//		String url="https://www.1688.com/jiage/-B9E3D6DDD6EDC8E2.html";
//		String content="广州猪肉价格不够给力？没有找到优质便宜的广州猪肉报价信息？ 马上发布询价单";
//		
//		searchItem.setTitle(title);
//		searchItem.setContent(content);
//		searchItem.setUrl(url);
		
		String keyword = "支付宝";
		int pageTotalNum=1;
		String engineNames="bing";
		
		List<SearchItem> list = null;
		try {
			list = spiderSearch.searchAndStore(keyword, pageTotalNum, engineNames);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}
}
