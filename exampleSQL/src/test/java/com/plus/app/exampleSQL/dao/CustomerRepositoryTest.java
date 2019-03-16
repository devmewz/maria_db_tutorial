package com.plus.app.exampleSQL.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.plus.app.exampleSQL.domain.Address;
import com.plus.app.exampleSQL.domain.Customer;
import com.plus.app.exampleSQL.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void whenFindAll_thenReturnAllCustomers() {
		// given
		Customer customer = new Customer();
		customer.setTitle("MR.");
		customer.setName("name");
		customer.setLastname("lastname");
		customerRepository.save(customer);

		// when
		List<Customer> customers = (List<Customer>) customerRepository.findAll();

		// then
		assertThat(customers).hasSize(1).contains(customer);
	}

	@Test
	public void whenFindByExactlyName_thenReturnCustomer() {
		// given
		Customer customer = new Customer();
		customer.setTitle("MR.");
		customer.setName("name");
		customer.setLastname("lastname");
		customerRepository.save(customer);
		
		Customer customer2 = new Customer();
		customer2.setTitle("MR.");
		customer2.setName("name2");
		customer2.setLastname("lastname2");
		customerRepository.save(customer2);

		// when
		List<Customer> customers = customerRepository.findByName("name");

		// then
		assertThat(customers).hasSize(1).contains(customer).doesNotContain(customer2);
	}
	
	@Test
	public void whenFindByLikeName_thenReturnCustomer() {
		// given
		Customer customer = new Customer();
		customer.setTitle("MR.");
		customer.setName("name");
		customer.setLastname("lastname");
		customerRepository.save(customer);
		
		Customer customer2 = new Customer();
		customer2.setTitle("MR.");
		customer2.setName("name2");
		customer2.setLastname("lastname2");
		customerRepository.save(customer2);

		// when
		List<Customer> customers = customerRepository.findByNameContaining("name");

		// then
		assertThat(customers).hasSize(2).contains(customer, customer2);
	}
	
	@Test
	public void whenFindByNameAndFetchAddress_thenreturnCustomerAndAddress() {
		// given
		Customer customer = new Customer();
		customer.setTitle("MR.");
		customer.setName("name");
		customer.setLastname("lastname");
		
		List<Address> addresses = new ArrayList<>();
		
		Address address = new Address();
		address.setDetail("detail");
		address.setDistrict("district");
		address.setProvince("Province");
		address.setZipCode("10000");
		address.setAddressType("contract");
		address.setCustomer(customer);
		addresses.add(address);
		
		customer.setAddresses(addresses);
		customerRepository.save(customer);
		
		// when
		List<Customer> customers = customerRepository.findByName("name");

		// then
		assertThat(customers).hasSize(1).contains(customer);
		assertThat(customers).flatExtracting("addresses").hasSize(1).contains(address);
	}

}
