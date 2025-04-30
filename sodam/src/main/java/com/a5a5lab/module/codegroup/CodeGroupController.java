package com.a5a5lab.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.common.BaseVo;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/sodam/xdm/CodeGroupXdmList")
	public String CodeGroupXdmList(Model model,CodeGroupDto Dto,@ModelAttribute("vo") BaseVo vo){
		vo.setParamsPaging(codeGroupService.selectOneCount(Dto));
		model.addAttribute("list",codeGroupService.selectList(Dto));
		return "xdm/codegroup/CodeGroupXdmList";
	}
	@RequestMapping(value="/sodam/xdm/CodeGroupXdmForm")
	public String CodeGroupXdmForm(Model model,CodeGroupDto Dto) {
		if (Dto.getIfcgSeq().equals("0") || Dto.getIfcgSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(Dto));
//			model.addAttribute("list", codeService.selectList(cvo));
		}
		return "xdm/codegroup/CodeGroupXdmForm";
	}
	@RequestMapping(value="/sodam/xdm/CodeGroupXdmInst")
	public String CodeGroupXdmInst(CodeGroupDto Dto) {
		codeGroupService.insert(Dto);
		return "redirect:/sodam/xdm/CodeGroupXdmList";
	}
	

}
