package com.a5a5lab.module.user.reservation;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface ReservationDao {
	
	public int insert(ReservationDto Dto);
	public List<ReservationDto> selectList(ReservationDto Dto);
	public int selectOneCount(ReservationDto Dto);
	

}
