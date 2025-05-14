package com.a5a5lab.module.user.review;

import java.util.Date;

public class ReviewDto {
	
	private String reSeq; //리뷰Seq
	private Integer starScore; //리뷰 별점
	private String reTitle; //리뷰 제목
	private String reText; //리뷰 내용
	private Integer reDelNy; //삭제 여부
	private Date regDateTime; //등록일
	private Date modDateTime; //수정일
	private String member_memSeq; //멤버 Seq
	private String stay_staySeq; //숙소 Seq
//	----
	private String staySeq; // 숙소 Seq
	private String stayName; //숙소이름
//	----
	private String memSeq; //멤버 Seq
	private String memName; //멤버 이름
//	----
	
	public String getReSeq() {
		return reSeq;
	}
	public void setReSeq(String reSeq) {
		this.reSeq = reSeq;
	}
	public Integer getStarScore() {
		return starScore;
	}
	public void setStarScore(Integer starScore) {
		this.starScore = starScore;
	}
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
	public String getReText() {
		return reText;
	}
	public void setReText(String reText) {
		this.reText = reText;
	}
	public Integer getReDelNy() {
		return reDelNy;
	}
	public void setReDelNy(Integer reDelNy) {
		this.reDelNy = reDelNy;
	}
	public Date getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Date getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}
	public String getMember_memSeq() {
		return member_memSeq;
	}
	public void setMember_memSeq(String member_memSeq) {
		this.member_memSeq = member_memSeq;
	}
	public String getStay_staySeq() {
		return stay_staySeq;
	}
	public void setStay_staySeq(String stay_staySeq) {
		this.stay_staySeq = stay_staySeq;
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
	public String getMemSeq() {
		return memSeq;
	}
	public void setMemSeq(String memSeq) {
		this.memSeq = memSeq;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
}