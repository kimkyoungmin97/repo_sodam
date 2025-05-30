package com.a5a5lab.module.user.stay;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface StayDao {
	
	
	// 사용자 숙소 정보 리스트
	public List<StayDto> stayList(StayVo vo);
	
	public List<StayDto> stayList1();
	
	//페이지네이션
	public int selectOneCount(StayVo vo);
	//리뷰페이지네이션
	public int reviewCount(StayVo vo);
	
	// 사용자 숙소 정보 리스트 상세 1개씩 뽑기
	public StayDto stayOne(StayDto stayDto);
	
	//호스트가 숙소 등로 리스트
	public List<StayDto> stayRegistrationList(int memSeq);
	
	//숙소등록
	public int insert(StayDto stayDto);
	//숙소수정
	public int update(StayDto stayDto);
	
	//숙소 리뷰 리스트 가져오기
	public List<StayDto> reviewList(StayVo vo);
	//숙소 이미지 리스트 가져오기
	public List<String> imgList(StayDto stayDto);
}
