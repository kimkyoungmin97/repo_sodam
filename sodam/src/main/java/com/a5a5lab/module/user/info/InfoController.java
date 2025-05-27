package com.a5a5lab.module.user.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.xdm.code.CodeDto;


@Controller
public class InfoController {
	@Autowired
	InfoService infoService;
	
	@RequestMapping(value="/user/info/infoList")
	public String infoList(Model model, @ModelAttribute("vo") InfoDto Dto) {
		
		model.addAttribute("list",infoService.selectList(Dto));
		
		return "user/info/infoList";
	
	}
	
	
	@RequestMapping(value="/user/info/infoView")
	public String infoView(Model model,@ModelAttribute("vo") InfoDto Dto) {
		if (Dto.getInfoSeq().equals("0") || Dto.getInfoSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item",infoService.selectOne(Dto));

		}
		
		
		return "user/info/infoView";
	
	}
	
	@RequestMapping(value="/user/info/infoInst")
	public String infoInst(InfoDto Dto) {
		infoService.insert(Dto);
		return "redirect:/user/info/infoList";
	}
	
	@RequestMapping(value="/infoUser")
	public String infoUser(Model model, @ModelAttribute("vo") InfoDto Dto) {
		
		model.addAttribute("list",infoService.selectList(Dto));
		
		return "user/info/infoUser";
		
	}
	
	@RequestMapping(value="/infoUserView")
	public String infoUserView(Model model,@ModelAttribute("vo") InfoDto Dto) {
		
		model.addAttribute("item",infoService.selectOne(Dto));
		
		return "user/info/infoUserView";
		
	}
	
}
