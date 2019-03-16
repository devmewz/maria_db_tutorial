package com.plus.app.exampleSQL.model;

import com.plus.app.exampleSQL.domain.Address;

public class AddressModel {

	private String addressType;
	private String address;

	public AddressModel(Address address) {
		this.addressType = address.getAddressType();
		this.address = address.getDetail() + " " + address.getDistrict() + " " + address.getProvince() + " "
				+ address.getZipCode();
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
