package com.vinay.InquireCustomer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {

	@GetMapping
	public String sayHello() {
		return "Hello and welcome to ICS application. You can retrieve a customer account information here !";
	}
}
