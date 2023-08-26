package com.ecommercecart.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommercecart.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
