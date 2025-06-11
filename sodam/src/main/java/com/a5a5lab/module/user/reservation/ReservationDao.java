package com.a5a5lab.module.user.reservation;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface ReservationDao {
	
	public int insert(ReservationDto Dto);
	public List<ReservationDto> selectList(ReservationDto Dto);
	public int selectOneCount(ReservationDto Dto);
	
	
	//스테이 관리자 스테이 예약 관리 리스트
	public List<ReservationDto> ReservationList(ReservationVo vo);
	
	//스테이 관리자 예약 취소 버튼
	public int ReservationUelet(int resSeq);

}
