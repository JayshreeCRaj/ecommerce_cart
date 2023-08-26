package com.ecommercecart.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercecart.models.Address;
import com.ecommercecart.models.Cart;
import com.ecommercecart.models.Orders;
import com.ecommercecart.repositories.OrdersRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CartService cartService;
	
	public Orders createOrders(Orders orders) {
		Cart cart = cartService.getSingleCart(orders.getCart().getCartId());
		orders.setCart(cart);
		Address address= addressService.getSingleAddress(orders.getAddress().getAddressId());
		//Given 1 address is enabled for 1 user, 
		//the following condition sets enabled address as delivery address for the order
		if(address.isEnabled()) {
			orders.setAddress(address);
		}
		else 
			throw new RuntimeException("No address is enabled");
		return ordersRepository.save(orders);
	}
	
	public Orders getSingleOrder(Integer orderId) {
		Optional<Orders> optional = ordersRepository.findById(orderId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			throw new RuntimeException("Order not found exception");
		
	}
	
	public Iterable<Orders> getAllProduct() {
		return ordersRepository.findAll();
	}

	public void deleteOrder(Integer orderId) {
		Orders order = getSingleOrder(orderId);
		ordersRepository.deleteById(order.getOrderId());
		
	}
}
