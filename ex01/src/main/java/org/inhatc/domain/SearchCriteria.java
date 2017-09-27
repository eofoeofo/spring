package org.inhatc.domain;

public class SearchCriteria  extends Criteria {
	
	private String searchType;
	private String Keyword;
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSerachType(String searchType) {
		this.searchType = searchType;
		
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return super.toString() + "SearchCriteria " + "[serachType=" + searchType +", keyword =" + keyword="+keyword +"]";
	}

}
