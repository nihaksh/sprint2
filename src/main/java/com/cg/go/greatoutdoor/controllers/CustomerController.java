package com.cg.go.greatoutdoor.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.dto.customer.CreateCustomerRequest;
import com.cg.go.greatoutdoor.dto.customer.CustomerDetails;
import com.cg.go.greatoutdoor.dto.customer.UpdateCustomerRequest;
import com.cg.go.greatoutdoor.entity.Customer;
import com.cg.go.greatoutdoor.service.ICustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;

	/**
     * effective url will be http://localhost:8585/customers/add
     */

	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails add(@RequestBody CreateCustomerRequest requestData) {
		Customer customer=new Customer(requestData.getCustomerName(),requestData.getMobileNo(),requestData.getEmail(),requestData.getAddress(),requestData.getRole());
		customer=customerService.addCustomer(customer);
		CustomerDetails details=toDetails(customer);
		return details;
	}

    @PutMapping("/update")
    public CustomerDetails update(@RequestBody UpdateCustomerRequest requestData) {
		Customer customer=new Customer(requestData.getCustomerName(),requestData.getMobileNo(),requestData.getEmail(),requestData.getAddress(),requestData.getRole());
		customer.setCustomerId(requestData.getCustomerId());
		customer=customerService.updateCustomer(customer);
		CustomerDetails details=toDetails(customer);
		return details;
		
	}

    @GetMapping("/allCustomers")
    public List<CustomerDetails> getAllCustomers(){
    	List<Customer> customers=customerService.getAllCustomers();
    	List<CustomerDetails> details=toDetails(customers);
    	return details;
    }
    
	@DeleteMapping("/remove/{id}")
    public String deleteCustomer(@PathVariable("id") Integer customerId) {
		customerService.removeCustomer(customerId);
		String response = "removed customer with id=" +customerId;
    	return response;
	}
	
	@GetMapping("by/customerId/{id}")
	public CustomerDetails findCustomer(@PathVariable("id") Integer customerId) {
		Customer customer=customerService.findById(customerId);
		CustomerDetails details=toDetails(customer);
		return details;
		
	}
	
	private CustomerDetails toDetails(Customer customer) {
		CustomerDetails details=new CustomerDetails(customer.getCustomerId(),customer.getCustomerName(),customer.getMobileNo(),
				customer.getEmail(),customer.getAddress(),customer.getRole());
		return details;
	}
	
	private List<CustomerDetails> toDetails(List<Customer> customers) {
    	List<CustomerDetails> customerDetails=new ArrayList<>();
    	for(Customer customer:customers) {
    		CustomerDetails details=toDetails(customer);
    		customerDetails.add(details);
    	}
		return customerDetails;
	}

}
