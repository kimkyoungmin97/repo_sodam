package com.a5a5lab.module.user.member;

public class MemberDto {
	
	// 멤버
	private String memSeq; //멤버 Seq
	private Integer memTypeCd; //멤버 타입 CD (사용자,호스트,관리자)
	private String memName; // 이름
	private Integer genderCd; // 성별 코드 (남자 여자 기타)
	private Integer foreignerCd; //내국인 외국인 
	private Integer agencyCd; //통신사 코드(LG SKT KT 알뜰)
	private String memTel; // 폰번호
	private String memEmail; //이메일
	private String memId; // ID
	private String memPw; // 비밀번호
	private String memDelNy; //삭제 여부
	private String regDate;// 등록일
	private String modDate; //수정일
//	----
	
	public String getMemSeq() {
		return memSeq;
	}
	public void setMemSeq(String memSeq) {
		this.memSeq = memSeq;
	}
	public Integer getMemTypeCd() {
		return memTypeCd;
	}
	public void setMemTypeCd(Integer memTypeCd) {
		this.memTypeCd = memTypeCd;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public Integer getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(Integer genderCd) {
		this.genderCd = genderCd;
	}
	public Integer getForeignerCd() {
		return foreignerCd;
	}
	public void setForeignerCd(Integer foreignerCd) {
		this.foreignerCd = foreignerCd;
	}
	public Integer getAgencyCd() {
		return agencyCd;
	}
	public void setAgencyCd(Integer agencyCd) {
		this.agencyCd = agencyCd;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemDelNy() {
		return memDelNy;
	}
	public void setMemDelNy(String memDelNy) {
		this.memDelNy = memDelNy;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	
}
