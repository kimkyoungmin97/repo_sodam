package com.a5a5lab.module.user.stay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayService {
	
	@Autowired
	StayDao stayDao;
	
	//사용자 숙박 정보 리스트 보여주기
	public List<StayDto> stayList(StayVo vo){
		return stayDao.stayList(vo);
	}
	
	//페이지 네이션
	public int selectOneCount(StayVo vo) {
		return stayDao.selectOneCount(vo);
	}
	
	//사용자 숙박 정보 리스트 상세
	public StayDto stayOne(StayDto stayDto) {
		
		return stayDao.stayOne(stayDto);
	}
	
	//사용자 스테이등록 했을때 리스트 상세
	public List<StayDto> stayRegistrationList(int memSeq){
		return stayDao.stayRegistrationList(memSeq);
	}
}
