package com.a5a5lab.module.user.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
	
	
	//MY 페이지 예약완료 리스트
	@RequestMapping(value="MyReservationsUser")
	public String MyReservationsUser() {
		
		return "/user/myreservations/MyReservationsUser";
	}
}
