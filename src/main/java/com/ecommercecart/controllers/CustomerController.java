package com.ecommercecart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercecart.models.Customer;
import com.ecommercecart.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer inputCustomer) {
		return customerService.createCustomer(inputCustomer);
	}
	
	@GetMapping("/all")
	public Iterable<Customer> getAllCustomers() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") Integer customerId) {
		return customerService.getSingleCustomer(customerId);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") Integer customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	
}
