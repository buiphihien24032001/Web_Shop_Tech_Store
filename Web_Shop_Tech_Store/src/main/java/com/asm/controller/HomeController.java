package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm.entity.Product;
import com.asm.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductService ProductService;
	@RequestMapping(value = {"/home/index","/"})
	public String home(Model model) {
		List<Product> list= ProductService.findAll();
		model.addAttribute("items", list);
		return "layout/index";
	}
	
	@RequestMapping(value = {"/admin","/admin/home/index"})
	public String admin() {
		return "assets/admin/index";
	}
}

