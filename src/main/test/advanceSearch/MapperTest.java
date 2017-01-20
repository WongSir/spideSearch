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
* @Description: dao��JUnit��Ԫ���� 
* @author hjd
* @date 2017��1��19�� ����6:56:12 
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
		 * TITLE:��������۸�_���¹�������۸�/��������_��������۸��ȫ ...
URL:https://www.1688.com/jiage/-B9E3D6DDD6EDC8E2.html
CONTENT:��������۸񲻹�������û���ҵ����ʱ��˵Ĺ������ⱨ����Ϣ�� ���Ϸ���ѯ�۵�
		 */
		String title="��������۸�_���¹�������۸�/��������_��������۸��ȫ ...";
		String url="https://www.1688.com/jiage/-B9E3D6DDD6EDC8E2.html";
		String content="��������۸񲻹�������û���ҵ����ʱ��˵Ĺ������ⱨ����Ϣ�� ���Ϸ���ѯ�۵�";
		String searchKey = "����";
		
		searchItem.setTitle(title);
		searchItem.setContent(content);
		searchItem.setUrl(url);
		searchItem.setSearchKey(searchKey);
		
		int addcount = advanceSearchDao.addSearchItem(searchItem);
		System.out.println(addcount);
	}
}
