package com.asm.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asm.entity.Product;
import com.asm.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService ProductService;
	
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return ProductService.findById(id);
	}
	
	@GetMapping()
	public List<Product> getAll() {
		return ProductService.findAll();
	}
}
