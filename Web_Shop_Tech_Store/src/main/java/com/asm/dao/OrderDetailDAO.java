package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{

}
