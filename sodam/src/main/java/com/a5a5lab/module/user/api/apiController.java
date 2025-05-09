package com.a5a5lab.module.user.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class apiController {
	
	@RequestMapping(value="/LocationRestaurant")
	public String LocationRestaurant() {
		return "/user/location/LocationRestaurant";
	}

}
