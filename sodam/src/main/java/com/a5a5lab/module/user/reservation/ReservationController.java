package com.a5a5lab.module.user.reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		return "user/myreservations/MyReservationsUser";
	}
	
	
	//호스트 스테이 예약 리스트
	@RequestMapping(value="/StayReservationUserList")
	public String StayReservationUserList() {
		
		return "user/stayreservation/StayReservationUserList";
	}
	
	//숙소 예약 정보 아작스 담기
	@ResponseBody
	@RequestMapping(value = "/DetailedPageUser")
	public Map<String, Object> DetailedPageUser(ReservationDto reservationDto, HttpSession session) throws Exception {
	    Map<String, Object> returnMap = new HashMap<>();

	    // 숙소 정보 Seq 담아오기
	    String rtt = reservationDto.getStaySeq();

	    // 체크인, 체크아웃 날짜 바로 사용 (이미 Date 타입임)
	    Date checkInDate = reservationDto.getCheckInDate();
	    Date checkOutDate = reservationDto.getCheckOutDate();

	    // 날짜 차이 계산
	    long diffInMillis = checkOutDate.getTime() - checkInDate.getTime();
	    long nights = diffInMillis / (1000 * 60 * 60 * 24); // 숙박 박수 계산

	    // 숙박 인원수와 가격 계산
	    int peopleCount = reservationDto.getCheckInPeoNum();

	    int pricePerPerson = 0;
	    if (reservationDto.getStayPrice() != null && !reservationDto.getStayPrice().isEmpty()) {
	        pricePerPerson = Integer.parseInt(reservationDto.getStayPrice());
	    }

	    // 총액 계산
	    int totalPrice = (int) (nights * peopleCount * pricePerPerson);
	    System.out.println("checkInDate: " + checkInDate);
	    System.out.println("checkOutDate: " + checkOutDate);
	    System.out.println("1인당 가격(pricePerPerson): " + pricePerPerson);
	    System.out.println("reservationDto.getStayPrice(): " + reservationDto.getStayPrice());
	    // 예약 정보에 총액 추가
	    reservationDto.setTotalPrice(totalPrice);

	    // 세션에 예약 정보 저장
	    session.setAttribute("reservationData", reservationDto);

	    // 결과 반환
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
	   
	    model.addAttribute("reservationData", reservationData);
	    model.addAttribute("stayInfoData", stayInfoData);
	    
	    
	    model.addAttribute("item", stayService.stayOne(stayDto));
	
	    
	    return "user/pay/PayUserForm"; // 실제 JSP 경로
	}

	
	
	
	
	
	
}
