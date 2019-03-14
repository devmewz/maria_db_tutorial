package com.plus.app.exampleSQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plus.app.exampleSQL.model.Customer;
import com.plus.app.exampleSQL.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/findAll")
	public List<Customer> findAll() {
		return customerService.findAllCustomer();
	}
}
