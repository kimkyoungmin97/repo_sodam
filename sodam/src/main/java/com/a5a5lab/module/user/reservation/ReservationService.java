package com.a5a5lab.module.user.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	@Autowired
	ReservationDao reservationDao;
	
	public int insert(ReservationDto Dto) {
		return reservationDao.insert(Dto);
	}
	public List<ReservationDto> selectList(ReservationDto Dto){
		return reservationDao.selectList(Dto);
		
	}
	public int selectOneCount(ReservationDto Dto) {
		return reservationDao.selectOneCount(Dto);
	}
	
	//스테이 관리자 스테이 예약 고나리 리스트
	public List<ReservationDto> ReservationList(ReservationVo vo){
		return reservationDao.ReservationList(vo);
	}
	//스테이 관리자 스테이 예약 리스트 취소하기
	public int ReservationUelet(int resSeq) {
		return reservationDao.ReservationUelet(resSeq);
	}
	

}
