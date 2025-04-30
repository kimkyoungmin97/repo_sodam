package com.a5a5lab.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	public List<CodeGroupDto> selectList(CodeGroupDto Dto){
		return codeGroupDao.selectList(Dto);
	}
	public int selectOneCount(CodeGroupDto Dto) {
		return codeGroupDao.selectOneCount(Dto);
	}
	public CodeGroupDto selectOne(CodeGroupDto Dto) {
		return codeGroupDao.selectOne(Dto);
	}
	public int insert(CodeGroupDto Dto) {
		return codeGroupDao.insert(Dto);
	}

}
