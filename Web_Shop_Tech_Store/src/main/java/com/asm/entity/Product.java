package com.asm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "Products")
@Data
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String image;
	Double price;
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	Date create_date=new Date();
	Boolean available;
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
	String single1;
	String single2;
	String single3;
	String des1;
	String des2;
	String des3;
	String desmain;
	String desfirst;
	String dessecond;
	String desthird;
	Double quantity;
	String thumb1;
	String thumb2;
	String thumb3;
}








