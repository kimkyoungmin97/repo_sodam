package com.a5a5lab.module.user.stay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.common.util.UtilDateTiem;

import jakarta.servlet.http.HttpSession;

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
	public String ReservationUserList(Model model, StayVo vo) {
		
		vo.setParamsPaging(stayService.selectOneCount(vo));
		
		model.addAttribute("list", stayService.stayList(vo));
		model.addAttribute("vo", vo);
		
		return "/user/reservation/ReservationUserList";
	}
	//사용자 숙박예약 리스트 상세
	@RequestMapping(value="DetailedPageUserForm")
	public String DetailedPageUserForm(Model model, StayDto stayDto, StayVo vo) {
		
		model.addAttribute("item", stayService.stayOne(stayDto));// 스테이 1개뽑아가기
		vo.setPageNumToShow(stayService.selectOneCount(vo)); // 페이지 네이션 // 리뷰 페이지네이션 할거임
		model.addAttribute("vo", vo);
		
		
		return "/user/detailedpage/DetailedPageUserForm";
		
	}

	
//	// 호스트 로그인했을때  스테이 리스트 보여주기
	@RequestMapping(value="/StayUserList")
	public String StayUserList(StayVo vo, Model model, HttpSession httpSession) {
		
		
	    Object obj = httpSession.getAttribute("sessSeqUser");
	    
	    int memSeq = Integer.parseInt(obj.toString()); 

	    List<StayDto> registrationList = stayService.stayRegistrationList(memSeq);
	    model.addAttribute("list", registrationList);

	    vo.setParamsPaging(stayService.selectOneCount(vo));
	    model.addAttribute("vo", vo);

	    return "/user/staylist/StayUserList";
	}
	
	
	// 호스트 로그인했을때 스테이 등록 폼
	@RequestMapping(value="StayUserFrom")
	public String StayUserFrom() {
		
		return "/user/stayfrom/StayUserFrom";
	}
	
	
}
