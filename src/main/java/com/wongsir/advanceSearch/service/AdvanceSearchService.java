package com.wongsir.advanceSearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wongsir.advanceSearch.dao.AdvanceSearchDao;
import com.wongsir.advanceSearch.entity.KeyWord;
import com.wongsir.advanceSearch.entity.SearchItem;

/** 
* @Description: �߼�����Service��
* @author hjd
* @date 2017��1��19�� ����1:39:37 
*  
*/
@Service
public class AdvanceSearchService {
	
	@Autowired
	private AdvanceSearchDao advanceSearchDao;
	
	//�洢��������ʵ��
	public int addSearchItem(SearchItem searchItem){
		int addcount = advanceSearchDao.addSearchItem(searchItem);
		return addcount;
	}
	
	public List<SearchItem> findAllSearch(){
		List<SearchItem> list = new ArrayList<SearchItem>();
		list = advanceSearchDao.findAllSearch();
		return list;
	}
	
	//�洢�ؼ���
	public int addKeyWord(KeyWord key){
		int addcount = advanceSearchDao.addKeyWord(key);
		return addcount;
	}
	
	//��ѯ���йؼ���
	public List<KeyWord> findAllKey(){
		List<KeyWord> keys = new ArrayList<KeyWord>();
		keys = advanceSearchDao.findAllKey();
		return keys;
	}
	
	/**
	 * �ؼ��ֲ�ѯ
	 * @param key
	 * @return
	 */
	public List<SearchItem> query(String key){
		List<SearchItem> list = new ArrayList<SearchItem>();
//		int flag =1;
//		if(flag != judgeKey(key)){
//			return list;
//		}
		list = advanceSearchDao.findByKey(key);
		return list;
	}
	
	//�жϹؼ����Ƿ��Ѵ���
	public int judgeKey(String key){
//		List<KeyWord> list = new ArrayList<KeyWord>();
		KeyWord keyword = new KeyWord();
		int flag = 1;
		keyword = advanceSearchDao.findKey(key);
		if(keyword!=null){
			flag=0;
			return flag; //flagΪ0��˵���ùؼ����Ѵ���
		}
		return flag;
	}
	
	//��keyword���в��ҹؼ���
	public KeyWord findKey(String key){
		KeyWord keyword = new KeyWord();
		keyword = advanceSearchDao.findKey(key);
		return keyword;
	}
	
	//ɾ������
	public int deleteSearchItem(String key){
		int deletecount = advanceSearchDao.deleteSearchItem(key);
		return deletecount;
		
	}
	
}
