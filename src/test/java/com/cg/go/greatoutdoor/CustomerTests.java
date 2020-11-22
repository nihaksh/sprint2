package com.cg.go.greatoutdoor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.go.greatoutdoor.dao.ICustomerRepository;
import com.cg.go.greatoutdoor.entity.Customer;
import com.cg.go.greatoutdoor.exception.CustomerException;
import com.cg.go.greatoutdoor.service.CustomerService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


@ExtendWith(MockitoExtension.class)
	public class CustomerTests {
		@InjectMocks
		private CustomerService service;

		@Mock
		private ICustomerRepository customerRepository;
		
		
		@Test
		 void testAddCustomer()  {
			
			Customer customer = Mockito.mock(Customer.class);
			Customer updated=Mockito.mock(Customer.class);
			Mockito.when(customerRepository.save(customer)).thenReturn(updated); 
			Customer result =service.addCustomer(customer);
			assertEquals(updated,result);

		}
		
		@Test
		void testUpdateCustomer()  {
			
			Customer customer = Mockito.mock(Customer.class);
			Customer updated=Mockito.mock(Customer.class);
			int customerId=5;
			Mockito.when(customer.getCustomerId()).thenReturn(customerId);
			Mockito.when(customerRepository.existsById(customerId)).thenReturn(true);
				
			
			Mockito.when(customerRepository.save(customer)).thenReturn(updated); 
			Customer result =service.updateCustomer(customer);
			assertEquals(updated,result);

		}
		@Test
		void test2UpdateCustomer()  {
			
			Customer customer = Mockito.mock(Customer.class);
			int customerId=5;
			
			Mockito.when(customerRepository.existsById(customerId)).thenReturn(false);
				Executable exe=()->service.updateCustomer(customer);
				assertThrows(CustomerException.class,exe);
			
			

		}
}