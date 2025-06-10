package com.a5a5lab.module.xdm.stayXdm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayXdmService {

	
	@Autowired
	StayXdmDao stayXdmDao;
	
	//숙박 등록 요청 리스트
	public List<StayXdmDto> stayXdmList(){
		return stayXdmDao.stayXdmList();
	}
	
}
