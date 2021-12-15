package com.cypher.br.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StatusAPIController {
	
	@GetMapping
	public String statusAPI() {
		return "Running";
	}

}
