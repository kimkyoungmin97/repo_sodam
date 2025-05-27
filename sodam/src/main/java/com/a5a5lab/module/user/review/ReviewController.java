package com.a5a5lab.module.user.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	// 리뷰 업데이트
	@ResponseBody
	@RequestMapping(value = "/reviewUdate")
	public Map<String, Object> reviewUdate(ReviewDto reviewDto, HttpSession httpSession) throws Exception {
	    
	    Map<String, Object> returnMap = new HashMap<>();
	    
	    // 리뷰 저장
	    reviewService.insert(reviewDto);
	    
	    // 성공 메시지 추가
	    returnMap.put("status", "success");
	    
	    return returnMap;
	}
	
	//My페이지 리뷰 작성 리스트 보여주기
	@RequestMapping(value="/WrittenReviewUser")
	public String MyReservationsUser(HttpSession session, Model model) {
		
		 // 세션에서 로그인한 사용자 suSeq 꺼내기
    	String memSeqStr = (String) session.getAttribute("sessSeqUser");
		
    	int memSeq = Integer.parseInt(memSeqStr);  // 문자열을 정수로 변환
    	
    	// 해당 사용자 리뷰 리스트 가져오기
        List<ReviewDto> reviewList = reviewService.reviewListByUser(memSeq);

        // 모델에 리스트 담아서 뷰로 전달
        model.addAttribute("list", reviewList);
		
		return "user/review/WrittenReviewUser";
	}
	
	//리뷰 업데이트 삭제
	@PostMapping("/ReviewUserUele")
	public String ReviewUserUele(@RequestParam("deleteIds") List<Long> deleteIds) {
		reviewService.uelete(deleteIds);
		return "redirect:/WrittenReviewUser";
	}
}
