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
	
	private int pagePerCnt = 2;
	private int pageNavCnt = 3;
}
