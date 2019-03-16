package com.plus.app.exampleSQL.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plus.app.exampleSQL.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public List<Customer> findByName(String name);
	
	public List<Customer> findByNameContaining(String name);

}
