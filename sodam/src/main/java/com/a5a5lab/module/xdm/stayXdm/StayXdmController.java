package com.a5a5lab.module.xdm.stayXdm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StayXdmController {

	@Autowired
	StayXdmService stayXdmService;
	
	//숙박 등록 요청 관리
	@RequestMapping(value="/sodam/xdm/StayRegistrationXdmList")
	public String StayRegistrationXdmList(Model model) {
		
		
		model.addAttribute("list", stayXdmService.stayXdmList()); // 숙박 등록 요청 관리 리스트 뿌리기
		
		return "xdm/stay/StayRegistrationXdmList";
	}
	
	
	
}
