package com.a5a5lab.module.user.info;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a5a5lab.module.xdm.code.CodeDto;

@Repository
public interface InfoDao {
	
	public List<InfoDto> selectList(InfoDto Dto);
	public InfoDto selectOne(InfoDto Dto);
	public int insert(InfoDto Dto);
}
