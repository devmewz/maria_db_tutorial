package com.plus.app.exampleSQL.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.app.exampleSQL.domain.Customer;
import com.plus.app.exampleSQL.model.CustomerModel;
import com.plus.app.exampleSQL.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerModel> getCustomers() {
		return ((List<Customer>) customerRepository.findAll()).stream().map(CustomerModel::new)
				.collect(Collectors.toList());
	}

	public List<CustomerModel> getCustomerByName(String name) {
		return customerRepository.findByNameContaining(name).stream().map(CustomerModel::new)
				.collect(Collectors.toList());
	}

	@Transactional
	public List<CustomerModel> getCustomerAddressByName(String name) {
		return customerRepository.findByNameContaining(name).stream()
				.map(item -> new CustomerModel(item, item.getAddresses())).collect(Collectors.toList());
	}

}
