package com.ecommercecart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommercecart.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


}
