package com.bmw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kenny")
public class DemoController {

	@GetMapping(value = "lee", produces = "application/json")
	public String helloWorld() {
		return "This is my hello world";
	}
}
