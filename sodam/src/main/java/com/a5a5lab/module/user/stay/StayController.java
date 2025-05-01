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
	
	
	
	
	
	
}
