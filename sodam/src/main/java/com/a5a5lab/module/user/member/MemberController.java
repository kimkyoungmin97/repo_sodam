package com.a5a5lab.module.user.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	//로그인화면 보여주기
	@RequestMapping(value="/SigninUser")
	public String SigninUser () {
		return "/user/signin/SigninUser";
	}
	
	//회원가입 유형 선택 보여주기
	@RequestMapping(value="/SignupUserSelect")
	public String SignupUserSelect() {
		
		return "/user/signup/SignupUserSelect";
	}
	
	
	//회원가입 폼 보여주기
	@RequestMapping(value="/SignupUserForm")
	public String SignupUserForm() {
		
		return "/user/signup/SignupUserForm";
	}
		
	// MY페이지 계정설정 폼 화면
	@RequestMapping(value="/MySettingUserForm")
	public String MYSettingUserForm() {
		
		return "/user/mysetting/MySettingUserForm";
	}
	
	//My페이지 비밀번호 변경
	@RequestMapping(value="/MyPasswordUserForm")
	public String MyPasswordUserForm() {
		
		return "/user/mypassword/MyPasswordUserForm";
	}
	
	//My페이지 회원 탈퇴 페이지
	@RequestMapping(value="MySecessionUser")
	public String MySecessionUser() {
		return"/user/mysecession/MySecessionUser";
	}
	
	
	
}
