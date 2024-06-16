package com.wu.onep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wu.onep.model.Customer;
import com.wu.onep.service.CustomerService;

@RestController
public class RedisController {
	
	@Autowired
	private CustomerService service;
	
	
	@GetMapping("/welcome")
    public String home(){
        return "home";
    }

	@GetMapping("/customer/{id}")
	public Customer getDetails(@PathVariable String id) {
		return service.getCustomerDetails(id);
		
	}
}
