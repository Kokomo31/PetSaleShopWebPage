package utils;

import java.util.Map;

public class Getpaging {

	public String Getpage(int totalCount , int pageSize ,int blockPage, int pageNum, String reqUrl, String params) {
		
		String pagingStr = "";
		
		int totalPages = (int) (Math.ceil(((double)totalCount/pageSize))); 
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
		
		if(pageTemp != 1) {		
			 pagingStr += "<li class='page-item'><a class='page-link' href='"+reqUrl+"?"+params+"&pageNum=1'>처음으로</a></li>";
					
			 pagingStr += "<li class='page-item'><a class='page-link' href='"+reqUrl+"?"+params+"&pageNum='"+pageTemp+-1+"'>이전</a></li>";
		}
		
	      int blockCount = 1;
	        while (blockCount <= blockPage && pageTemp <= totalPages) {
	            if (pageTemp == pageNum) {
	            		pagingStr += "<li class='page-item active'><a class='page-link' href='#'>"+pageTemp+"</a></li>";
	            } 
	            else {
	            	//현제 페이지가 아닌 경우에만 링크를 걸어준다. 
	                	pagingStr += "<li class='page-item'><a class='page-link' href='"+reqUrl+"?"+params+"&pageNum="+pageTemp+"'>"+pageTemp+"</a></li>";
	            }
	            pageTemp++;
	            blockCount++;
	        }

	        //다음 페이지 블록 바로가기 링크 출력
	        if (pageTemp <= totalPages) {
	            pagingStr += "<li class='page-item'><a class='page-link' href='"+reqUrl+"?"+params+"&pageNum="+pageTemp+"'>>></a></li>";
	            pagingStr += "<li class='page-item'><a class='page-link' href='"+reqUrl+"?"+params+"&pageNum="+totalPages+"'>마지막페이지</a></li>";
	        }

	        return pagingStr;
		
	}
}
		
