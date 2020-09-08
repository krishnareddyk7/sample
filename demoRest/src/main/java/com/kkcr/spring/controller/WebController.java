package com.kkcr.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kkcr.spring.Person;

@RestController
public class WebController {
	
	@RequestMapping("/sample")
	public Person Sample(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		Person response = new Person();
		response.setId(1);
		response.setMessage("Your name is "+name);
		return response;

	}

}
