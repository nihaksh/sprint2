package com.cg.go.greatoutdoor.service;


import java.util.List;

import com.cg.go.greatoutdoor.entity.Customer;


public interface ICustomerService {


	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void removeCustomer(Integer customerId);
	public Customer findById(int customerId);
	//Customer viewCustomer(Customer customer);
}
