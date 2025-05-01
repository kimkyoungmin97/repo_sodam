package com.a5a5lab.module.user.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InfoController {
	@Autowired
	InfoService infoService;
	
	@RequestMapping(value="/user/info/infoList")
	public String infoList() {
		
		
		return "/user/info/infoList";
	
	}
}
