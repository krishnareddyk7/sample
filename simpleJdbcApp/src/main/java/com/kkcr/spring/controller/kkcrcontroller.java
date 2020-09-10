package com.kkcr.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkcr.spring.repository.KkcrRepository;

//make this as Rest Controller

@RestController
@RequestMapping(path = "/simple")
public class kkcrcontroller {

	@Autowired
	KkcrRepository KkcrRepository;
	// to teat our service is up and running
	@GetMapping
	public String check() {
		return "hi All My Servie is Up and running....!";
	}
	
	/**
	 * This method will return the List of Names
	 * @return
	 */
	
	@GetMapping(path = "/getNames")
	public List<String> getAllKkcr(){
		return KkcrRepository.getAllNames();
	}
	
	@GetMapping(path = "/getAll")
	public String getAll() {
		return KkcrRepository.getAll();
		
	}
}
