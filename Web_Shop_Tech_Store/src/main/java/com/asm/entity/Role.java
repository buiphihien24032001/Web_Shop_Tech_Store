package com.asm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "Roles")
@Data
public class Role implements Serializable{
	@Id
	String id;
	String name;
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
}
