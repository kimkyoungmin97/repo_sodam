package com.a5a5lab.module.user.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	

	
	
	//로그인화면 보여주기
	@RequestMapping(value="/SigninUser")
	public String SigninUser () {
		return "/user/signin/SigninUser";
	}
	//admin 로그인화면 보여주기
	@RequestMapping(value="/sodam/xdm/SigninXdm")
	public String SigininXdm() {
		return"/xdm/signin/SigninXdm";
	}
	//admin 로그인화면 아작스
	@ResponseBody
	@RequestMapping(value="/sodam/xdm/SigninXdmProc")
	public Map<String, Object> SigninXdmProc(MemberDto Dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		MemberDto rtMember = memberService.selectOneLogin(Dto);
		if(rtMember != null) {
			returnMap.put("rt","success");
		}else {
			
		}
	
		
		//암호화
//		if(matchesBcrypt(dto.getUserPw(),rtMember.getUserPw(),10)) {
//			returnMap.put("rt","success");
//			httpSession.setAttribute("sessSeqXdm", rtMember.getUserSeq());
//			httpSession.setAttribute("sessIdXdm", rtMember.getUserId());
//			httpSession.setAttribute("sessNameXdm", rtMember.getUserName());	
//
//		} else {
//			
//		}
		return returnMap;
	}
	
	
	//회원가입 유형 선택 보여주기
	@RequestMapping(value="/SignupUserSelect")
	public String SignupUserSelect() {
		
		return "/user/signup/SignupUserSelect";
	}
	
	
	//회원가입 폼 보여주기
	@RequestMapping(value="/SignupUserForm")
	public String SignupUserForm(MemberDto Dto,Model model) {
		model.addAttribute("item", Dto);
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
