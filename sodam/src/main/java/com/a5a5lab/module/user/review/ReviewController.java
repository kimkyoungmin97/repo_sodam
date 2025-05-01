package com.a5a5lab.module.user.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
	
	
	//My페이지 리뷰 작성 리스트 보여주기
	@RequestMapping(value="/WrittenReviewUser")
	public String MyReservationsUser() {
		
		return "/user/review/WrittenReviewUser";
	}
}
