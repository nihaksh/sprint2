package com.cg.go.greatoutdoor.dto.customer;


import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.cg.go.greatoutdoor.entity.Address;

public class CreateCustomerRequest {
	private String customerName;
	private String mobileNo;
	private String email;
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	private String role; //sales representative or retailer
	
	public CreateCustomerRequest( String customerName, String mobileNo, String email, Address address,String role) {
		
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.role = role;
	}
	public CreateCustomerRequest() {
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
