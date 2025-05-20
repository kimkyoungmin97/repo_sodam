package com.a5a5lab.module.user.stay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.module.common.fileuploaded.FileUploadedService;
import com.a5a5lab.module.user.review.ReviewDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class StayController {
	

	@Autowired
	StayService stayService;
	@Autowired
	FileUploadedService fileUploadedService;
	//사용자 인덱스 화면 보여주기
	@RequestMapping(value="/indexUser")
	public String indexUser() {
		
		return "/user/index/IndexUser";
	}
	
	
	//사용자 숙박예약 리스트
	@RequestMapping(value="/ReservationUserList")
	public String ReservationUserList(Model model, StayVo vo ) {
		
		vo.setParamsPaging(stayService.selectOneCount(vo));
		
		model.addAttribute("list", stayService.stayList(vo));
		
		model.addAttribute("vo", vo);
		
		return "/user/reservation/ReservationUserList";
	}
	//사용자 숙박예약 리스트 상세
	@RequestMapping(value="DetailedPageUserForm")
	public String DetailedPageUserForm(Model model, StayDto stayDto, StayVo vo) {
		
		
	    // 리뷰 목록을 가져옴
	    List<StayDto> reviewList = stayService.reviewList(vo);

	    // 총 리뷰 개수 계산
	    int totalReviews = reviewList.size();

	    // 각 별점별 비율 계산 (1 ~ 5점)
	    int[] ratingCounts = new int[5]; // 별점 1 ~ 5의 개수
	    for (StayDto review : reviewList) {
	        int starScore = review.getStarScore();
	        if (starScore >= 1 && starScore <= 5) {
	            ratingCounts[starScore - 1]++;
	        }
	    }

	    // 각 별점 비율 계산
	    double[] ratingPercentages = new double[5];
	    for (int i = 0; i < 5; i++) {
	        ratingPercentages[i] = (totalReviews > 0) ? (double) ratingCounts[i] / totalReviews * 100 : 0.0;
	    }

	    // 평균 별점 계산 (리뷰가 있을 때만 계산)
	    double averageRating = 0.0;
	    if (totalReviews > 0) {
	        double totalRating = 0.0;
	        for (StayDto review : reviewList) {
	            totalRating += review.getStarScore(); // 각 리뷰의 별점 점수를 더함
	        }
	        averageRating = totalRating / totalReviews; // 평균 별점 계산
	    }
		
	    model.addAttribute("averageRating", averageRating); // 평균 별점
	    model.addAttribute("ratingPercentages", ratingPercentages); // 별점별 비율
	    model.addAttribute("reviewList", reviewList); // 리뷰 목록
		model.addAttribute("item", stayService.stayOne(stayDto));// 스테이 1개뽑아가기
		model.addAttribute("list", stayService.imgList(stayDto));// 숙소 이미지 리스트
		vo.setParamsPaging(stayService.reviewCount(vo)); // 페이지 네이션 // 리뷰 페이지네이션 할거임
		model.addAttribute("vo", vo);
		
		
		return "/user/detailedpage/DetailedPageUserForm";
		
	}
	// 숙소예약페이지 리뷰목록페이지네이션 아작스
		@ResponseBody
		@RequestMapping(value = "/reviewProc")
		public Map<String, Object> reviewUdate(StayVo vo, HttpSession httpSession) throws Exception {
		    
		    Map<String, Object> returnMap = new HashMap<>();
		    
			  System.out.println("getThisPage():" + vo.getThisPage());
				System.out.println("getTotalRows():" + vo.getTotalRows());
				System.out.println("getRowNumToShow():" + vo.getRowNumToShow());
				System.out.println("getTotalPages():" + vo.getTotalPages());
			    System.out.println("getStartPage():" + vo.getStartPage());
			    System.out.println("getEndPage():" + vo.getEndPage());
//				
				System.out.println("getStartRnumForMysql(): " + vo.getStartRnumForMysql());
		    return returnMap;
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
	public String StayUserFrom(StayDto stayDto,Model model) {
		if (stayDto.getStaySeq() == null) {
//			insert mode
		} else {
//			update mode
			
			model.addAttribute("item",stayService.stayOne(stayDto));
		}
		
		
		return "/user/stayfrom/StayUserFrom";
	}
	
	//숙소등록
	@RequestMapping(value="/StayInst")
	public String StayInst(StayDto stayDto,HttpSession httpSession) throws Exception {
		
		stayDto.setMember_memSeq((String) httpSession.getAttribute("sessSeqUser"));
		stayService.insert(stayDto);
		return "redirect:/StayUserList";
	}
	//숙소수정
	@RequestMapping(value="/StayUpdt")
	public String StayUpdt(StayDto stayDto, HttpSession httpSession) throws Exception {
		stayService.update(stayDto);
		return "redirect:/StayUserList";
	}
	
	
}
