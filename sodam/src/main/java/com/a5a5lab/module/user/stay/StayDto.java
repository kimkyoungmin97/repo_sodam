package com.a5a5lab.module.user.stay;

import java.util.Date;

public class StayDto {
	// Stay
	private String staySeq; //숙박 Seq
	private String stayName; // 숙박 이름
	private String stayZipCode; // 숙박 우편번호
	private String stayAddress; // 숙박 주소
	private String stayAddressDetail; //주소 상세
	private double stayLatitude; //위도
	private double stayHardness; //경도
	private String stayIntroMemo; // 숙소 소개
	private String stayServiceMemo; //숙소 시설/서비스
	private String stayNoticeMemo; // 숙소 예약 공지
	private Date regDateTime; // 등록일
	private Date modDateTime; // 수정일
	private Integer regionCd; // 지역 코드
	private Integer activeCd; // 운영상태 (운영중 운영중지 운영대기)
	private String member_memSeq; //멤버 Seq
//	----
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
	public String getStayZipCode() {
		return stayZipCode;
	}
	public void setStayZipCode(String stayZipCode) {
		this.stayZipCode = stayZipCode;
	}
	public String getStayAddress() {
		return stayAddress;
	}
	public void setStayAddress(String stayAddress) {
		this.stayAddress = stayAddress;
	}
	public String getStayAddressDetail() {
		return stayAddressDetail;
	}
	public void setStayAddressDetail(String stayAddressDetail) {
		this.stayAddressDetail = stayAddressDetail;
	}
	public double getStayLatitude() {
		return stayLatitude;
	}
	public void setStayLatitude(double stayLatitude) {
		this.stayLatitude = stayLatitude;
	}
	public double getStayHardness() {
		return stayHardness;
	}
	public void setStayHardness(double stayHardness) {
		this.stayHardness = stayHardness;
	}
	public String getStayIntroMemo() {
		return stayIntroMemo;
	}
	public void setStayIntroMemo(String stayIntroMemo) {
		this.stayIntroMemo = stayIntroMemo;
	}
	public String getStayServiceMemo() {
		return stayServiceMemo;
	}
	public void setStayServiceMemo(String stayServiceMemo) {
		this.stayServiceMemo = stayServiceMemo;
	}
	public String getStayNoticeMemo() {
		return stayNoticeMemo;
	}
	public void setStayNoticeMemo(String stayNoticeMemo) {
		this.stayNoticeMemo = stayNoticeMemo;
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
	public Integer getRegionCd() {
		return regionCd;
	}
	public void setRegionCd(Integer regionCd) {
		this.regionCd = regionCd;
	}
	public Integer getActiveCd() {
		return activeCd;
	}
	public void setActiveCd(Integer activeCd) {
		this.activeCd = activeCd;
	}
	public String getMember_memSeq() {
		return member_memSeq;
	}
	public void setMember_memSeq(String member_memSeq) {
		this.member_memSeq = member_memSeq;
	}
	
}
