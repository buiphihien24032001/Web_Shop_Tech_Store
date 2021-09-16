package com.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message2", "Vui lòng đăng nhập!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "security/login";
	}
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message2", "Sai thông tin đăng nhập");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message2", "Không có quyền truy xuất !");
		return "security/login";
	}
	@RequestMapping("/security/logoff/success")
	public String logoff(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "security/login";
	}
	
}






