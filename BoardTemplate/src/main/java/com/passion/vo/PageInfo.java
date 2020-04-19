package com.passion.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageInfo {
	
	private int totCnt;
	
	private int totPage;
	private int currentPage=1;
	private int firstPage = 1;
	private int lastPage; 
	
	private int startPage=1;
	private int endPage;
	
	private int pagePerCnt = 5;
	private int pageNavCnt = 5;
	
	
	public void calcNav(PageInfo page) {
		

		int lstPage = 0;
		int totalCount = page.getTotCnt();
		
		lstPage = totalCount%page.getPagePerCnt()==0 ?  totalCount/page.getPagePerCnt() : (totalCount/page.getPagePerCnt()) + 1;
		page.setLastPage(lstPage);
		
		
		int currentPage = page.getCurrentPage();
		
		int mok = currentPage/pageNavCnt;
		int rest = currentPage%pageNavCnt;
		
		if(rest==0) {
			page.setEndPage(pageNavCnt*mok); 
		}else {
			page.setEndPage(pageNavCnt*mok+pageNavCnt); 
		}
		page.setStartPage(page.getEndPage() - pageNavCnt +1);
		if(page.getLastPage()<page.getEndPage())
			page.setEndPage(page.getLastPage());
	}
}
