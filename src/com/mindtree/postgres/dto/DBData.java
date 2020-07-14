package com.mindtree.postgres.dto;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DBData {
	
	@XmlAttribute(name= "Id")
	private String id;
	
	@XmlAttribute(name = "FirstName")
	private String first_name;
	
	@XmlAttribute(name = "LastName")
	private String last_name;
	
	@XmlAttribute(name = "Email")
	private String email;
	
}
