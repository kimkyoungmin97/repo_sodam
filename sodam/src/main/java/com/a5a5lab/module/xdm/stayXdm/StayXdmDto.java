package com.a5a5lab.module.xdm.stayXdm;

public class StayXdmDto {

	
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
	private String regDateTime; // 등록일
	private String modDateTime; // 수정일
	private Integer regionCd; // 지역 코드
	private Integer activeCd; // 운영상태 (운영중 운영중지 운영대기)
	private String member_memSeq; //멤버 Seq
	private Integer stayPrice; //가격
	private Integer stayPersonnel; // 숙박정원
	private Integer stDeNy; // 삭제 여부
//	----
	private String memSeq; // 호스트 Seq
	private String memName; // 호스트 이름
	private String memTel; // 호스트 번호

//	--대표이미지 인덱스
	private Integer representativeIndex;
	private Double averageRating;
//	-----
	
	private String reSeq; //리뷰 Seq
	private Integer starScore; // 리뷰 별점
	private String reTitle; // 리뷰 제목
	private String reText; // 리뷰 내용
	private String reDelNy; // 리뷰 업데이트 삭제
	private String stay_staySeq; // 스테이 Seq
//	----
	private String path; //파일경로
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
	public String getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}
	public String getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(String modDateTime) {
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
	public Integer getStayPrice() {
		return stayPrice;
	}
	public void setStayPrice(Integer stayPrice) {
		this.stayPrice = stayPrice;
	}
	public Integer getStayPersonnel() {
		return stayPersonnel;
	}
	public void setStayPersonnel(Integer stayPersonnel) {
		this.stayPersonnel = stayPersonnel;
	}
	public Integer getStDeNy() {
		return stDeNy;
	}
	public void setStDeNy(Integer stDeNy) {
		this.stDeNy = stDeNy;
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
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public Integer getRepresentativeIndex() {
		return representativeIndex;
	}
	public void setRepresentativeIndex(Integer representativeIndex) {
		this.representativeIndex = representativeIndex;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
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
	public String getReDelNy() {
		return reDelNy;
	}
	public void setReDelNy(String reDelNy) {
		this.reDelNy = reDelNy;
	}
	public String getStay_staySeq() {
		return stay_staySeq;
	}
	public void setStay_staySeq(String stay_staySeq) {
		this.stay_staySeq = stay_staySeq;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
