package com.ecommercecart.services;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercecart.models.Cart;
import com.ecommercecart.models.Customer;
import com.ecommercecart.models.Product;
import com.ecommercecart.repositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;

	public Cart createCart(Cart cart) {
		List<Product> products = new LinkedList<>();
		Iterator<Product> iterator = cart.getProducts().iterator(); 
		Product existingProduct = new Product();
		while(iterator.hasNext()) { 
			existingProduct = productService.getSingleProduct(iterator.next().getProductId());
			products.add(existingProduct); 
		}
		cart.setProducts(products);
		Customer customer= customerService.getSingleCustomer(cart.getCustomer().getCustomerId());
		cart.setCustomer(customer);
		return cartRepository.save(cart);
	}
	
	public Cart getSingleCart(Integer cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			throw new RuntimeException("Cart not found exception");
		
	}
	
	public Iterable<Cart> getAllCartItems() {
		return cartRepository.findAll();
	}
	
	public void deleteCart(Integer cartId) {
		Cart cart = getSingleCart(cartId);
		cartRepository.deleteById(cart.getCartId());
		
	}
	

}
