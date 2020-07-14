package com.mindtree.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.mindtree.service.PostgresService;

 

@RestController
public class PostgresController {
	
	@Autowired
	PostgresService postgreService;

	@GetMapping(value = "/empInfo")
	public String db() throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParserConfigurationException, JAXBException, SAXException, IOException, TransformerException {
		
		 postgreService.pgDatabase(); 
		 
		return "inserted in data";

	}
	
	/*
	 * @PostMapping(value="/kafkaConsumer", produces="application/json") public
	 * String consumerGet( @RequestBody String message) throws
	 * NoSuchMethodException, SecurityException, IllegalAccessException,
	 * IllegalArgumentException, InvocationTargetException, SQLException {
	 * postgreService.consumeKafkaMindtree(message); return "consumed"; }
	 */
}
