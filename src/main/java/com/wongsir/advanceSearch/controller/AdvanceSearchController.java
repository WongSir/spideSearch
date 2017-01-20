package com.wongsir.advanceSearch.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wongsir.advanceSearch.entity.KeyWord;
import com.wongsir.advanceSearch.entity.SearchItem;
import com.wongsir.advanceSearch.service.AdvanceSearchService;
import com.wongsir.advanceSearch.service.SpiderSearch;

/** 
* @Description: TODO 
* @author hjd
* @date 2017��1��19�� ����2:43:13 
*  
*/
@RestController
@RequestMapping("views/")
public class AdvanceSearchController {
	@Autowired
	private AdvanceSearchService advanceSearchService;
	@Autowired
	private SpiderSearch spiderSearch;
	
	/**
	 * ���ݹؼ���������ץȡ
	 * @param key
	 * @return
	 */
	@RequestMapping(value="advanceSearch/{key}")
	public List<SearchItem> searchAndCrawling(@PathVariable String key){
		List<SearchItem> list = new ArrayList<SearchItem>();
		int flag=1; //flag=1,�ùؼ���û������
		if(flag != advanceSearchService.judgeKey(key)){
			advanceSearchService.deleteSearchItem(key);
		}
		try {
			spiderSearch.searchByKey(key); //ץȡ
			list = advanceSearchService.query(key);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@RequestMapping(value="advanceSearch/findAllSearch")
	public List<SearchItem> findAllSearch(){
		List<SearchItem> list = new ArrayList<SearchItem>();
		list = advanceSearchService.findAllSearch();
		return list;
	}
	
	/**
	 * ��ѯ���йؼ���
	 * @return
	 */
	@RequestMapping(value="advanceSearch/findAllKey")
	public List<KeyWord> findAllKey(){
		List<KeyWord> keys = new ArrayList<KeyWord>();
		keys = advanceSearchService.findAllKey();
		return keys;
	}
	
	
}
