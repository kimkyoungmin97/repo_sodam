package com.a5a5lab.module.user.info;

import com.a5a5lab.module.common.BaseVo;

public class InfoDto extends BaseVo {
	public String infoSeq;
	public String infoTitle;
	public String infoText;
	public Integer infoDelNy;
	public String regDate;
	public String modDate;
//  -----
	public String getInfoSeq() {
		return infoSeq;
	}
	public void setInfoSeq(String infoSeq) {
		this.infoSeq = infoSeq;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoText() {
		return infoText;
	}
	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}
	public Integer getInfoDelNy() {
		return infoDelNy;
	}
	public void setInfoDelNy(Integer infoDelNy) {
		this.infoDelNy = infoDelNy;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	
	
	
}
