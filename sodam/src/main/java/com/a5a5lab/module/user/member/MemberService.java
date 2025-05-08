package com.a5a5lab.module.user.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a5a5lab.module.xdm.codegroup.CodeGroupDto;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	

	public List<MemberDto> selectList(MemberDto Dto){
		return memberDao.selectList(Dto);
	}
	
	public int selectOneCount(MemberDto Dto) {
		return memberDao.selectOneCount(Dto);
	}	
	public MemberDto selectOneLogin(MemberDto Dto) {
		return memberDao.selectOneLogin(Dto);

	}
}
