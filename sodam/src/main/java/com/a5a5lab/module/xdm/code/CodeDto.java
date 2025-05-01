package com.a5a5lab.module.xdm.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.a5a5lab.module.common.BaseVo;

public class CodeDto extends BaseVo {
	
	private String ifcdSeq;
	private String ifcdName;
	private String codeGroup_ifcgSeq;
	private String modDate;
	private String regDate;
	private Integer ifcdUseNy;
	private Integer ifcdDelNy;
	
//	codegroup
	private String ifcgSeq;
	private String ifcgName;
	
	
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public Integer getIfcdUseNy() {
		return ifcdUseNy;
	}
	public void setIfcdUseNy(Integer ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}
	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public String getCodeGroup_ifcgSeq() {
		return codeGroup_ifcgSeq;
	}
	public void setCodeGroup_ifcgSeq(String codeGroup_ifcgSeq) {
		this.codeGroup_ifcgSeq = codeGroup_ifcgSeq;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}




	//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}

}
