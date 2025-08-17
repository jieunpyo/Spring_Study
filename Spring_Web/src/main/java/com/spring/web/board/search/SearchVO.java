package com.spring.web.board.search;

public class SearchVO {
	
	private String searchWord; // title, content
	private String key; // 홍길동, 성춘향
	
	public SearchVO() {
		
	}

	public String getSearchWord() {
		
		if(searchWord == null) {
			searchWord = "";
		}
		
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getKey() {
		
		if(key == null) {
			key = "";
		}
		
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
	
	
}
