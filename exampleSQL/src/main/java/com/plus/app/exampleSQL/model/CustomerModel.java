package com.plus.app.exampleSQL.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.plus.app.exampleSQL.domain.Address;
import com.plus.app.exampleSQL.domain.Customer;

public class CustomerModel {

	private String title;
	private String name;
	private String lastname;
	@JsonInclude(value = Include.NON_NULL)
	private List<AddressModel> addresses;

	public CustomerModel(Customer customer) {
		this.title = customer.getTitle();
		this.name = customer.getName();
		this.lastname = customer.getLastname();
	}
	
	public CustomerModel(Customer customer, List<Address> addresses) {
		this(customer);
		this.addresses = addresses.stream().map(AddressModel::new).collect(Collectors.toList());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFullname() {
		return title + " " + name + " " + lastname;
	}

	public List<AddressModel> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressModel> addresses) {
		this.addresses = addresses;
	}

}
