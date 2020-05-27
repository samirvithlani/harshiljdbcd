package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class SpringBootHarshilJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHarshilJdbcApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(SpringBootHarshilJdbcApplication.class);
	}

}
