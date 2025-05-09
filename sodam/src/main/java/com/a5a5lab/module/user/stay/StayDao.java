package com.a5a5lab.module.user.stay;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface StayDao {
	
	
	// 사용자 숙소 정보 리스트
	public List<StayDto> stayList(StayVo vo);
	
	//페이지네이션
	public int selectOneCount(StayVo vo);
	
	// 사용자 숙소 정보 리스트 상세 1개씩 뽑기
	public StayDto stayOne(StayDto stayDto);
	
	//호스트가 숙소 등로 리스트
	public List<StayDto> stayRegistrationList(int memSeq);
	
	//숙소등록
	public int insert(StayDto stayDto);
}
