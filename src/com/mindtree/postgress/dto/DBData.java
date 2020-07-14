package com.mindtree.postgress.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DBData {
	
	@XmlAttribute(name= "Id")
	private int id;
	
	@XmlAttribute(name = "name")
	private String name; 
	
	@XmlAttribute(name = "email")
	private String email;
	
}
