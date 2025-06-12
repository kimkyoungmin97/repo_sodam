package com.a5a5lab.module.user.stay;

import java.sql.Date;
import java.util.List;

import javax.xml.crypto.Data;

public class StayVo {
	
//	paging
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = 3;								// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = 5;								// 화면에 보여줄 페이징 번호 갯수

	private int totalRows;										// 전체 데이터 갯수
	private int totalPages;										// 전체 페이지 번호
	private int startPage;										// 시작 페이지 번호
	private int endPage;										// 마지막 페이지 번호

	private int startRnumForMysql = 0;							// 쿼리 시작 row
//	----
	private String staySeq;

//	search
	private Integer shUseNy = 1; 									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shDelNy = 0; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shValue;
//	----
	private String stayName;
//	----
//	검색 날짜
	private Data regDateTime;
	private Data modDateTime;
//	----
	private Date shQptionDate;
//	----
	 private List<String> regions;
	 private String regionName;
	 private String shRegion;  // ex: "16,17"
	private String stayAddress;
	  private String shRating;  // ex: "5,4"
	  private String shStar;
//	----
	
	    private List<String> ratings;
	    private String keyword;
	
	
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getRowNumToShow() {
		return rowNumToShow;
	}
	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}
	public int getPageNumToShow() {
		return pageNumToShow;
	}
	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}
	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}
	
	public Integer getShUseNy() {
		return shUseNy;
	}
	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
	}
	public Integer getShDelNy() {
		return shDelNy;
	}
	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}
	public Integer getShOptionDate() {
		return shOptionDate;
	}
	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}
	public String getShDateStart() {
		return shDateStart;
	}
	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}
	public String getShDateEnd() {
		return shDateEnd;
	}
	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}
	public Integer getShOption() {
		return shOption;
	}
	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}
	public String getShValue() {
		return shValue;
	}
	public void setShValue(String shValue) {
		this.shValue = shValue;
	}

	public Data getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Data regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Data getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(Data modDateTime) {
		this.modDateTime = modDateTime;
	}
	public Date getShQptionDate() {
		return shQptionDate;
	}
	public void setShQptionDate(Date shQptionDate) {
		this.shQptionDate = shQptionDate;
	}
	
	
	public void setParamsPaging(int totalRows) {
//		setThisPage(3);

		setTotalRows(totalRows);	// 전체 페이지 갯수
		
		// 토탈 데이커 값이 0개일때 페이지 수 1개로 설정을 하겠다 
		if (getTotalRows() == 0) {	 
			setTotalPages(1);
		} else {
			// 토탈페이지에서 (전체 데이값에서 /나누기 화면에보여줄 데이터갯수 줄이 5개씩 보여주겠다)
			setTotalPages(getTotalRows() / getRowNumToShow()); 
		}
		
		
		//(전체 데이터값 () 나누고 남은 5개씩 나누고 남은 데이터값을 0보다 클때 )
		if (getTotalRows() % getRowNumToShow() > 0) {
			//페이지를 1개안에 나머지 값을 넣겠다
			setTotalPages(getTotalPages() + 1);
		}
		
		
		// 전체페이지 보다 현제 페이지가 클때
		if (getTotalPages() < getThisPage()) {
			// 현제페이지를 토탈 페이지 안에 맞춰주겠다
			setThisPage(getTotalPages());
		}
		
		
		//첫페이지는 ((	(현제페이지 -1) 나누기 현제보여준 페이지 갯수 )곱하기 화면에 보여줄페이지 갯수 +1을 하겠다)
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		// 마지막 페이지 는 시작페이지 번호 + 보여줄페이지 번호 -1 하겠다
		// 1,2,3,4,5 를 보여주겠다
		// 마지마페이지 번호는 1번 페이지  + 페이지 겟수 5개 = 6 - 1 하겠다
		setEndPage(getStartPage() + getPageNumToShow() - 1);
		
		// 마지막 페이지 는 총페이지 보다 클경우
		if (getEndPage() > getTotalPages()) {
			//마지막페이지는 토탈페이지 안에 넣겠다
			setEndPage(getTotalPages());
		}
		
		// 첫페이지에 1부터 5개 데이터 값을 뿌리고 그다음 2번째 페잊 부터 6번부터 10번까지 뿌려주겠다
		// 첫페이지 에
		if (thisPage == 1) {
			// 0부터 시작하겠다
			setStartRnumForMysql(0);
		} else {
			// 0번 일때 데이터값 5 개 * 지금페이지 -1;
			
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
		
		
		

//		  System.out.println("getThisPage():" + getThisPage());
//		System.out.println("getTotalRows():" + getTotalRows());
//		System.out.println("getRowNumToShow():" + getRowNumToShow());
//		System.out.println("getTotalPages():" + getTotalPages());
//	    System.out.println("getStartPage():" + getStartPage());
//	    System.out.println("getEndPage():" + getEndPage());
//
//		System.out.println("getStartRnumForMysql(): " + getStartRnumForMysql());
		
	}
	public String getStaySeq() {
		return staySeq;
	}
	public void setStaySeq(String staySeq) {
		this.staySeq = staySeq;
	}
	public String getStayName() {
		return stayName;
	}
	public void setStayName(String stayName) {
		this.stayName = stayName;
	}
	public String getStayAddress() {
		return stayAddress;
	}
	public void setStayAddress(String stayAddress) {
		this.stayAddress = stayAddress;
	}
	public void setRegion(String region) {
		// TODO Auto-generated method stub
		
	}
	public void setRegions(List<String> regions) {
		// TODO Auto-generated method stub
		
	}
	public List<String> getRegions() {
		return regions;
	}

	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getShRegion() {
		return shRegion;
	}
	public void setShRegion(String shRegion) {
		this.shRegion = shRegion;
	}
	public String getShRating() {
		return shRating;
	}
	public void setShRating(String shRating) {
		this.shRating = shRating;
	}
	public String getShStar() {
		return shStar;
	}
	public void setShStar(String shStar) {
		this.shStar = shStar;
	}
	public List<String> getRatings() {
		return ratings;
	}
	public void setRatings(List<String> ratings) {
		this.ratings = ratings;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


}
