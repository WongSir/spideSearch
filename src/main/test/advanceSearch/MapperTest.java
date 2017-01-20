package advanceSearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wongsir.advanceSearch.App;
import com.wongsir.advanceSearch.dao.AdvanceSearchDao;
import com.wongsir.advanceSearch.entity.SearchItem;

/** 
* @Description: dao层JUnit单元测试 
* @author hjd
* @date 2017年1月19日 下午6:56:12 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class MapperTest {
	@Autowired
	private AdvanceSearchDao advanceSearchDao;
	
	@Test
	public void addSearchItem(){
		SearchItem searchItem = new SearchItem();
		/**
		 * TITLE:广州猪肉价格_最新广州猪肉价格/批发报价_广州猪肉价格大全 ...
URL:https://www.1688.com/jiage/-B9E3D6DDD6EDC8E2.html
CONTENT:广州猪肉价格不够给力？没有找到优质便宜的广州猪肉报价信息？ 马上发布询价单
		 */
		String title="广州猪肉价格_最新广州猪肉价格/批发报价_广州猪肉价格大全 ...";
		String url="https://www.1688.com/jiage/-B9E3D6DDD6EDC8E2.html";
		String content="广州猪肉价格不够给力？没有找到优质便宜的广州猪肉报价信息？ 马上发布询价单";
		String searchKey = "猪肉";
		
		searchItem.setTitle(title);
		searchItem.setContent(content);
		searchItem.setUrl(url);
		searchItem.setSearchKey(searchKey);
		
		int addcount = advanceSearchDao.addSearchItem(searchItem);
		System.out.println(addcount);
	}
}
