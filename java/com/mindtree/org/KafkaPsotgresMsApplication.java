package com.mindtree.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mindtree.*"})
public class KafkaPsotgresMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPsotgresMsApplication.class, args);
	}

}
