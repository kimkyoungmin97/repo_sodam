package com.a5a5lab.module.xdm.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	public List<CodeDto> selectList(CodeDto Dto);
	public int selectOneCount(CodeDto Dto);
	public CodeDto selectOne(CodeDto Dto);
	public List<CodeDto> selectListCachedCodeArrayList();
	public List<CodeDto> codeGroupList(CodeDto Dto);
	public int insert(CodeDto Dto);

}
