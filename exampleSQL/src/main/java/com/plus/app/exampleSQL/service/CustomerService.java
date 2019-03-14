package com.plus.app.exampleSQL.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.app.exampleSQL.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<com.plus.app.exampleSQL.model.Customer> findAllCustomer() {
		return ((List<com.plus.app.exampleSQL.domain.Customer>) customerRepository.findAll()).stream().map(com.plus.app.exampleSQL.model.Customer::new).collect(Collectors.toList());
	}
	
}
