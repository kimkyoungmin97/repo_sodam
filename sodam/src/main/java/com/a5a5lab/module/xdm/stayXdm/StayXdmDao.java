package com.a5a5lab.module.xdm.stayXdm;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface StayXdmDao {

	//숙소등록 요청 리스트
	public List<StayXdmDto> stayXdmList();
}
