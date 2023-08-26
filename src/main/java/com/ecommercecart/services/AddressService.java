package com.ecommercecart.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercecart.models.Address;
import com.ecommercecart.models.Customer;
import com.ecommercecart.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired 
	private CustomerService customerService;
	
	public Address createAddress(Address address) {
		Customer customer= customerService.getSingleCustomer(address.getCustomer().getCustomerId());
		address.setCustomer(customer);
		return addressRepository.save(address);
		
	}
	
	public Address getSingleAddress(Integer addressId) {
		Optional<Address> optional = addressRepository.findById(addressId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			throw new RuntimeException("Address not found exception");
		
	}
	
	public void deleteAddress(Integer addressId) {
		Address address = getSingleAddress(addressId);
		addressRepository.deleteById(address.getAddressId());
		
	}

	public Iterable<Address> getAllAddress() {
		return addressRepository.findAll();
	}

}
