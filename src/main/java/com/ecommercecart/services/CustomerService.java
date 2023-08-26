package com.ecommercecart.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercecart.models.Customer;
import com.ecommercecart.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	public Customer getSingleCustomer(Integer customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			throw new RuntimeException("Customer not found exception");
		
	}
	
	public void deleteCustomer(Integer customerId) {
		Customer customer = getSingleCustomer(customerId);
		customerRepository.deleteById(customer.getCustomerId());
		
	}

	public Iterable<Customer> getAllCustomer() {		
		return customerRepository.findAll();
	}

}
