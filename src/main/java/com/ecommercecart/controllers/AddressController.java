package com.ecommercecart.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercecart.models.Address;
import com.ecommercecart.services.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/create")
	public Address createAddress(@RequestBody @Valid Address address) {
		return addressService.createAddress(address);	
	}
	
	@GetMapping("/{id}")
	public Address getSingleAddress(@PathVariable("id") Integer addressId) {
		
		return addressService.getSingleAddress(addressId);
	}
	
	@GetMapping("/all")
	public Iterable<Address> getAllAddress() {
		return addressService.getAllAddress();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable("id") Integer addressId) {
		addressService.deleteAddress(addressId);
	}
	
	
}
