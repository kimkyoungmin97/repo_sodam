package com.a5a5lab.module.xdm.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.common.BaseVo;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value="/sodam/xdm/CodeXdmList")
	public String CodeXdmList(Model model,@ModelAttribute("vo")CodeDto Dto) {
		Dto.setParamsPaging(codeService.selectOneCount(Dto));
		model.addAttribute("list",codeService.selectList(Dto));
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value="/sodam/xdm/CodeXdmForm")
	public String CodeXdmForm(Model model,@ModelAttribute("vo")CodeDto Dto) {
		if (Dto.getIfcdSeq().equals("0") || Dto.getIfcdSeq().equals("")) {
//			insert mode
			model.addAttribute("codegroupList", codeService.codeGroupList(Dto));
		} else {
//			update mode
			model.addAttribute("item", codeService.selectOne(Dto));
//			model.addAttribute("list", codeService.selectList(cvo));
		}
		return "xdm/code/CodeXdmForm";
	}
	@RequestMapping(value="/sodam/xdm/CodeXdmInst")
	public String CodeXdmInst(CodeDto Dto) {
		codeService.insert(Dto);
		return "redirect:/sodam/xdm/CodeXdmList";
	}

}
