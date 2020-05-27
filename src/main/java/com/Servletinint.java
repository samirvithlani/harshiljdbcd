package com;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class Servletinint {

	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootHarshilJdbcApplication.class);
	}
}
