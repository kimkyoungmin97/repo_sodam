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
	public String CodeXdmList(Model model,CodeDto Dto,@ModelAttribute("vo") BaseVo vo) {
		vo.setParamsPaging(codeService.selectOneCount(Dto));
		model.addAttribute("list",codeService.selectList(Dto));
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value="/sodam/xdm/CodeXdmForm")
	public String CodeGroupXdmForm(Model model,@ModelAttribute("vo")CodeDto Dto) {
		if (Dto.getIfcgSeq().equals("0") || Dto.getIfcgSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeService.selectOne(Dto));
//			model.addAttribute("list", codeService.selectList(cvo));
		}
		return "xdm/codegroup/CodeXdmForm";
	}

}
