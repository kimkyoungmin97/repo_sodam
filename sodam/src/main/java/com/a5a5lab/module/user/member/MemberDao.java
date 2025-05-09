package com.a5a5lab.module.user.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a5a5lab.module.xdm.codegroup.CodeGroupDto;

@Repository
public interface MemberDao {
	

	public List<MemberDto> selectList(MemberDto Dto);
	public int selectOneCount(MemberDto Dto);

	public MemberDto selectOneLogin(MemberDto Dto);

	
	
	//사용자 로그인 비교
	public MemberDto selectId(MemberDto memberDto);
	//회원가입
	public int signup(MemberDto memberDto);
	//계정설정 정보수정
	public int userUpdate(MemberDto memberDto);
}