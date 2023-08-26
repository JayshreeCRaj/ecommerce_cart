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

import com.ecommercecart.models.Product;
import com.ecommercecart.services.ProductService;

	
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody @Valid Product product) {
		return productService.createProduct(product);	
	}
	
	
	@GetMapping("/{id}")
	public Product getSingleProduct(@PathVariable("id") Integer productId) {
		
		return productService.getSingleProduct(productId);
	}
	
	@GetMapping("/all")
	public Iterable<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Integer productId) {
		productService.deleteProduct(productId);		
	}

	

}
