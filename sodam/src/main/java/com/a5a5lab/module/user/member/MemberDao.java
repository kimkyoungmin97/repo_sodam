package com.a5a5lab.module.user.member;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public MemberDto selectOneLogin(MemberDto Dto);

}
