package com.asm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "Authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"username", "role_id"})
})
@Data
public class Authority implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@ManyToOne
	@JoinColumn(name = "username")
	Account account;
	@ManyToOne
	@JoinColumn(name = "role_id")
	Role role;
	

}
