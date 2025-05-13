package com.a5a5lab.module.user.reservation;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationDto {
	
	private String resSeq; //예약 Seq
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkInDate; // 체크인 날짜
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkOutDate; // 체크아웃 날짜
	private String checkInName; //체크인 하는 사람 이름
	private String checkInTel;//체크인 하는사람 번호
	private Integer checkInPeoNum; // 체크인 인원수
	private Integer meansOfVisitingCd; // 차량 or 대중교통
	private String member_memSeq; //멤버 Seq
	private String stay_staySeq; //숙소 Seq
	private Integer totalPrice; //숙소 예약 했을때 토탈 요금
//	----
	private String staySeq; // 스테이 Seq
	private String stayName;  // 숙박 이름
	private String stayAddress; //숙박 주소
	private String stayPrice; // 숙박 가격
//	----
	
	public String getResSeq() {
		return resSeq;
	}
	public void setResSeq(String resSeq) {
		this.resSeq = resSeq;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getCheckInName() {
		return checkInName;
	}
	public void setCheckInName(String checkInName) {
		this.checkInName = checkInName;
	}
	public String getCheckInTel() {
		return checkInTel;
	}
	public void setCheckInTel(String checkInTel) {
		this.checkInTel = checkInTel;
	}
	public Integer getCheckInPeoNum() {
		return checkInPeoNum;
	}
	public void setCheckInPeoNum(Integer checkInPeoNum) {
		this.checkInPeoNum = checkInPeoNum;
	}
	public Integer getMeansOfVisitingCd() {
		return meansOfVisitingCd;
	}
	public void setMeansOfVisitingCd(Integer meansOfVisitingCd) {
		this.meansOfVisitingCd = meansOfVisitingCd;
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
	public String getStayAddress() {
		return stayAddress;
	}
	public void setStayAddress(String stayAddress) {
		this.stayAddress = stayAddress;
	}
	public String getStayPrice() {
		return stayPrice;
	}
	public void setStayPrice(String stayPrice) {
		this.stayPrice = stayPrice;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
