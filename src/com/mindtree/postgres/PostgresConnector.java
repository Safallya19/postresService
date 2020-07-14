package com.mindtree.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 
@SpringBootApplication(scanBasePackages= {"com.mindtree.postgres.*"})
public class PostgresConnector {
 
	public static void main(String[] args) {
		SpringApplication.run(PostgresConnector.class, args);

	}
}
