package com.a5a5lab.module.user.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a5a5lab.module.xdm.codegroup.CodeGroupDto;

@Repository
public interface MemberDao {
	

	public List<MemberDto> selectList(MemberDto Dto);
	public int selectOneCount(MemberDto Dto);

	public MemberDto selectOneLogin(MemberDto Dto);


}
