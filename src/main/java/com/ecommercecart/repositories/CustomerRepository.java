package com.ecommercecart.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommercecart.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
