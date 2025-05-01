package com.a5a5lab.module.user.stay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StayController {
	

	@Autowired
	StayService stayService;
	
	
	
	
	
	
	
	//사용자 인덱스 화면 보여주기
	@RequestMapping(value="/indexUser")
	public String indexUser() {
		
		return "/user/index/IndexUser";
	}
	
	
	//사용자 숙박예약 리스트
	@RequestMapping(value="/ReservationUserList")
	public String ReservationUserList() {
		
		return "/user/reservation/ReservationUserList";
	}
	
	
	// 호스트 로그인했을때  스테이 리스트 보여주기
	@RequestMapping(value="/StayUserList")
	public String StayUserList() {
		
		return "/user/staylist/StayUserList";
	}
	
	
	
}
