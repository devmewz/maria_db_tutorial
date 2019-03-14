package com.plus.app.exampleSQL.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
		assertThat(customers).isNotEmpty();
	}

}
