package com.wongsir.advanceSearch.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wongsir.advanceSearch.entity.KeyWord;
import com.wongsir.advanceSearch.entity.SearchItem;

/** 
* @Description:  dao������
* @author hjd
* @date 2017��1��19�� ����11:26:42 
*  
*/
@Mapper
public interface AdvanceSearchDao {
	@Insert("insert into searchitem(title,content,url,searchKey) values(#{title},#{content},#{url},#{searchKey})")
	int addSearchItem(SearchItem searchItem);
	
	//ÿ��׼��������ȡʱ�Ƚ��йؼ����жϣ�����Ѵ��ڸùؼ��֣������ֱ���ڱ��ز�ѯ������Ҫ���²�ѯ����������ݿ������е�����
	//�ؼ���ģ��ƥ�� ���ݱ�  ������ͳ��  CONCAT('%',',${cityId},','%' )
	@Select("select count(*) from searchitem where title like CONCAT('%',#{key},'%' )")
	List<SearchItem> matchByKey(@Param("key") String key);
	
	
	@Select("select * from searchitem where searchKey = #{key}")
	List<SearchItem> findByKey(@Param("key") String key);
	
//	@Select("select * from searchitem where searchKey = #{k}")
//	SearchItem findSearchKey(@Param("k") String key);
	
	//��ѯ����������������
	@Select("select * from searchitem")
	List<SearchItem> findAllSearch();
	
	//����ؼ���
	@Insert("insert into keyword(keyWord) values(#{key})")
	int addKeyWord(KeyWord key);
	
	//��ѯ���йؼ���
	@Select("select * from keyword")
	List<KeyWord> findAllKey();
	
	//ÿ��׼��������ȡʱ�Ƚ��йؼ����жϣ�����Ѵ��ڸùؼ��֣������ֱ���ڱ��ز�ѯ������Ҫ���²�ѯ����������ݿ������е�����
	@Select("select * from keyword where keyWord = #{k}")
	KeyWord findKey(@Param("k") String key);
	
	@Update("update searchitem set title=#{Item.title},content=#{Item.content},url=#{Item.url} where title like CONCAT('%',',#{key},','%' )")
	int updateSearchItem(@Param("Item") SearchItem searchItem,@Param("key") String key);
	
	//���ݹؼ���ɾ����������
	@Delete("delete from searchitem where searchKey = #{key}")
	int deleteSearchItem(String key);

}
