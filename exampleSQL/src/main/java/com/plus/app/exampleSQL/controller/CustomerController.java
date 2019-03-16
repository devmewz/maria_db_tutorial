package com.plus.app.exampleSQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.plus.app.exampleSQL.model.CustomerModel;
import com.plus.app.exampleSQL.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<CustomerModel> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customer/name/{name}")
	public List<CustomerModel> getCustomerByName(@PathVariable("name") String name) {
		return customerService.getCustomerByName(name);
	}
	
	@GetMapping("/customeraddress/name/{name}")
	public List<CustomerModel> getCustomerAddressByName(@PathVariable("name") String name) {
		return customerService.getCustomerAddressByName(name);
	}
}
