package com.mindtree.model;

import javax.persistence.Column;

import lombok.Data;

@Data
public class DBData {
	
	@Column(name= "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	 
	@Column(name = "email")
	private String email;
	
}
