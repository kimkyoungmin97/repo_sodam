package com.a5a5lab.module.user.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public MemberDto selectOneLogin(MemberDto Dto) {
		return memberDao.selectOneLogin(Dto);
	}
	
	// 로그인 아작스 ID 
	public MemberDto selectId(MemberDto memberDto){
		return memberDao.selectId(memberDto);
	} 
}
