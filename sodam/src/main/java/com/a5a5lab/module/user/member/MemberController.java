package com.a5a5lab.module.user.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.common.BaseVo;
import com.a5a5lab.module.xdm.codegroup.CodeGroupDto;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/user/member/memberList")
	public String memberList(Model model,MemberDto Dto,@ModelAttribute("vo") BaseVo vo){
		vo.setParamsPaging(memberService.selectOneCount(Dto));
		model.addAttribute("list",memberService.selectList(Dto));
		
		return "user/member/memberList";
	}
	

	@RequestMapping(value="/user/member/memberView")
	public String memberView(){
		
		return "user/member/memberView";
	}

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
		

	
	
}
