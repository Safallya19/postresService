package com.mindtree.postgres.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.mindtree.postgres.service.PostgreSQLService;

@RestController
@Configuration
public class PostgresController {
	@Autowired
	PostgreSQLService  postgresSqlService;
 

	@GetMapping(value = "/getData")
	public String dbcall() throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ParserConfigurationException, JAXBException,
			SAXException, IOException, TransformerException {
		  
		 
         return postgresSqlService.pgDatabase();
	}
	


}
