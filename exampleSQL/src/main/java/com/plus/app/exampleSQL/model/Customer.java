package com.plus.app.exampleSQL.model;

public class Customer {

	private String title;
	private String name;
	private String lastname;
	
	public Customer(com.plus.app.exampleSQL.domain.Customer customerDomain) {
		this.title = customerDomain.getTitle();
		this.name = customerDomain.getName();
		this.lastname = customerDomain.getLastname();
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

}
