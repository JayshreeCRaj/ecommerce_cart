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

import com.ecommercecart.models.Cart;
import com.ecommercecart.services.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/create")
	public Cart createCart(@RequestBody @Valid Cart cart) {
		return cartService.createCart(cart);	
	}
	
	
	@GetMapping("/{id}")
	public Cart getSingleOrder(@PathVariable("id") Integer cartId) {
		
		return cartService.getSingleCart(cartId);
	}
	
	@GetMapping("/all")
	public Iterable<Cart> getAllCartItems()
	{
		return cartService.getAllCartItems();
	}
	
	@DeleteMapping("/{id}")
	public void deleteCart(@PathVariable("id") Integer cartId) {
		cartService.deleteCart(cartId);
	}

}
