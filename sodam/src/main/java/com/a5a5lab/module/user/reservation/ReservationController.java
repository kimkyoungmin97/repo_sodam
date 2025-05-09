package com.a5a5lab.module.user.reservation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.module.user.stay.StayDto;
import com.a5a5lab.module.user.stay.StayService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	StayService stayService;
	
	//MY 페이지 예약완료 리스트
	@RequestMapping(value="/MyReservationsUser")
	public String MyReservationsUser() {
		
		return "/user/myreservations/MyReservationsUser";
	}
	
	
	//호스트 스테이 예약 리스트
	@RequestMapping(value="/StayReservationUserList")
	public String StayReservationUserList() {
		
		return "/user/stayreservation/StayReservationUserList";
	}
	
	//숙소 예약 정보 아작스 담기
	@ResponseBody
	@RequestMapping(value = "/DetailedPageUser")
	public Map<String, Object> DetailedPageUser(ReservationDto reservationDto, HttpSession session) throws Exception {
	    Map<String, Object> returnMap = new HashMap<>();
	    
	    //숙소 정보 Seq 담아오기
	    String rtt =  reservationDto.getStaySeq();
	    
	    // 세션에 저장
	    session.setAttribute("reservationData", reservationDto);
	 
	    
	    returnMap.put("result", rtt);
	    
	    return returnMap;
	}
	
	
	// 숙소 예약 결제 했을때 인덱스 화면으로 가라
	@RequestMapping(value="/PayUserForm")
	public String PayUserForm(HttpSession session, Model model,StayDto stayDto) {
		
		
	   
		
		
	    // 세션에서 예약 정보 꺼내기
		ReservationDto reservationData = (ReservationDto) session.getAttribute("reservationData");
	    StayDto stayInfoData = (StayDto) session.getAttribute("stayInfoData");
		
	    
	    
	    // 필요한 정보 모델에 담기
	    model.addAttribute("item", stayService.stayOne(stayDto));
	    model.addAttribute("reservationData", reservationData);
	    model.addAttribute("stayInfoData", stayInfoData);
	
	    
	    return "/user/pay/PayUserForm"; // 실제 JSP 경로
	}
	
	
	
	
	
	
}
