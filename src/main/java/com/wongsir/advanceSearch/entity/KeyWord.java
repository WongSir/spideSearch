package com.wongsir.advanceSearch.entity;

/** 
* @Description: �ؼ���ʵ���� 
* @author hjd
* @date 2017��1��19�� ����2:02:50 
*  
*/
public class KeyWord {
	private String keyWord;
	
	public KeyWord(){
		
	}
	
	public KeyWord(String key){
		this.keyWord = key;
	}

	public String getKey() {
		return keyWord;
	}

	public void setKey(String key) {
		this.keyWord = key;
	}

	@Override
	public String toString() {
		return "KeyWord [key=" + keyWord + "]";
	}
	
}
