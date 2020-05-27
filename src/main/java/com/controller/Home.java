package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	
		@RequestMapping(value = "/")
		public String home() {
			System.out.println("home called..");
			return "Hello";
		}
	
}
