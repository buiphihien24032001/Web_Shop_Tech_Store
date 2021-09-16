package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.dao.ProductDAO;
import com.asm.entity.Product;
import com.asm.service.ProductService;

@Service
public class ProductServicelmpl implements ProductService{
	@Autowired
	ProductDAO pDao;

	@Override
	public List<Product> findAll() {
		return pDao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		
		return pDao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		return pDao.findByCategoryId(cid);
	}

	
}
