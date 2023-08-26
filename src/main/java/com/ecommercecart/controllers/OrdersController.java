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

import com.ecommercecart.models.Orders;
import com.ecommercecart.services.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	
	@PostMapping("/create")
	public Orders createOrders(@RequestBody @Valid Orders orders) {
		return ordersService.createOrders(orders);	
	}
	
	
	@GetMapping("/{id}")
	public Orders getSingleOrder(@PathVariable("id") Integer orderId) {
		
		return ordersService.getSingleOrder(orderId);
	}
	
	@GetMapping("/all")
	public Iterable<Orders> getAllProduct()
	{
		return ordersService.getAllProduct();
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable("id") Integer orderId) {
		ordersService.deleteOrder(orderId);
		
		
	}
	
}
