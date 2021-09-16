package com.asm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "Orderdetails")
@Data
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Double price;
	Double quantity;
	@ManyToOne
	@JoinColumn(name = "product_id")
	Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	Order order;
}
