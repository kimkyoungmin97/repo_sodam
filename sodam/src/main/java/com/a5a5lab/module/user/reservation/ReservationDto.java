package com.a5a5lab.module.user.reservation;

import java.util.Date;

public class ReservationDto {
	
	private String resSeq; //예약 Seq
	private Date checkInDate; // 체크인 날짜
	private Date checkOutDate; // 체크아웃 날짜
	private String checkInName; //체크인 하는 사람 이름
	private String checkInTel;//체크인 하는사람 번호
	private String checkInPeoNum; // 체크인 인원수
	private Integer meansOfVisitingCd; // 차량 or 대중교통
	private String member_memSeq; //멤버 Seq
	private String stay_staySeq; //숙소 Seq
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
	public String getCheckInPeoNum() {
		return checkInPeoNum;
	}
	public void setCheckInPeoNum(String checkInPeoNum) {
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
	
}
