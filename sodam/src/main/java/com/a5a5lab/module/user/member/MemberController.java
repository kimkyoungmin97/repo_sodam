package com.a5a5lab.module.user.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

import com.a5a5lab.module.common.BaseVo;





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
	
	
	//사용자 로그인화면 구현
	@ResponseBody
	@RequestMapping(value = "/SigninUser1")
	public Map<String, Object> SigninUser1(MemberDto memberDto, HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		MemberDto rtt = memberService.selectId(memberDto);
			
//			if (matchesBcrypt(memberDto.getMemPw(), rtt.getMemPw(), 10)) {
				
				returnMap.put("rt", "success");
				httpSession.setAttribute("sessSeqUser", rtt.getMemSeq()); //사용자Seq
				httpSession.setAttribute("sessIdUser", rtt.getMemId()); // ID
				httpSession.setAttribute("sessNameUser", rtt.getMemName());   //이름
				httpSession.setAttribute("sessMemTypeUser", rtt.getMemTypeCd());   //회원타입
				
				
				
	
//			} else {
//				
//				
//			}
			return returnMap;
	}
	
	//사용자 로그아웃 구현
	@ResponseBody
	@RequestMapping(value = "/SignoutUser1")
	public Map<String, Object> SignoutUser1(MemberDto memberDto,HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		httpSession.setAttribute("sessSeqUser", null);
		httpSession.setAttribute("sessIdUser", null);
		httpSession.setAttribute("sessNameUser", null);
		httpSession.setAttribute("sessMemTypeUser", null);   
		/* httpSession.invalidate(); */ //세션 전체 초기화
		returnMap.put("rt", "success");
			
			
		return returnMap;
			
	}
	
//	// 비밀번호 암포화
//	// 회원가입시 암포화
//	public String encodeBcrypt(String planeText, int strength) {
//		  return new BCryptPasswordEncoder(strength).encode(planeText);
//	}
//
//	// 로그인 했을때 암호화 비교 후 로그인		
//	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
//	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
//	  return passwordEncoder.matches(planeText, hashValue);
//	}
//	
	
	
	
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
	

	//회원가입
	@RequestMapping(value="/signupInst")
	public String signupInst(MemberDto memberDto) {
		memberService.signup(memberDto);
		return"redirect:/SigninUser";
	}
	
	
	
	

	

	
	
}
