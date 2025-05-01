package com.a5a5lab.module.xdm.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> selectList(CodeDto Dto){
		return codeDao.selectList(Dto);
	}
	
	public int selectOneCount(CodeDto Dto) {
		return codeDao.selectOneCount(Dto);
	}
	public CodeDto selectOne(CodeDto Dto) {
		return codeDao.selectOne(Dto);
	}
	public List<CodeDto> codeGroupList(CodeDto Dto){
		return codeDao.codeGroupList(Dto);
	}
	public int insert(CodeDto Dto) {
		return codeDao.insert(Dto);
	}
	

//	---cashe---
	 @PostConstruct
		public void selectListCachedCodeArrayList() throws Exception {
			List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
			CodeDto.cachedCodeArrayList.clear(); 
			CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
			System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
		}
	    
	    
		public static void clear() throws Exception {
			CodeDto.cachedCodeArrayList.clear();
		}
		
		
		public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
			List<CodeDto> rt = new ArrayList<CodeDto>();
			for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
				if (codeRow.getCodeGroup_ifcgSeq().equals(ifcgSeq)) {
					rt.add(codeRow);
				} else {
					// by pass
				}
			}
			return rt;
		}

		
		public static String selectOneCachedCode(int code) throws Exception {
			String rt = "";
			for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
				if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
					rt = codeRow.getIfcdName();
				} else {
					// by pass
				}
			}
			return rt;
		}
	

}
