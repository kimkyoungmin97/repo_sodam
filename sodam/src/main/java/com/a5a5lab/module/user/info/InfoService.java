package com.a5a5lab.module.user.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a5a5lab.module.user.member.MemberDto;
import com.a5a5lab.module.xdm.code.CodeDto;

@Service
public class InfoService {
	@Autowired
	InfoDao infoDao;
	
	public List<InfoDto> selectList(InfoDto Dto){
		return infoDao.selectList(Dto);
	}
	public InfoDto selectOne(InfoDto Dto){
		return infoDao.selectOne(Dto);
	}
	public int insert(InfoDto Dto) {
		return infoDao.insert(Dto);
	}
}
