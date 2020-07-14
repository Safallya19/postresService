package com.mindtree.postgres.dto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "PostgreSQLData")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostgreSQLResponse {

	@XmlElement(name = "Data")
	private List<DBData> data = new ArrayList<>();
}
