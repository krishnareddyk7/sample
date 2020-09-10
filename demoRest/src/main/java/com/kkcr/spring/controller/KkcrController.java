package com.kkcr.spring.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kkcr.spring.Kkcr;

@RestController
public class KkcrController {
	
	@RequestMapping(value="/kkcr", method = RequestMethod.POST)
	public ResponseEntity<Object> createKkcr(@RequestBody Kkcr kkcr){
		
		return null;
	}
	
	@RequestMapping(value="/kkcr", method = RequestMethod.GET)
	public ResponseEntity<Object> getKkcr(){
		
		return null;
	}

}
