package com.ecommercecart.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercecart.models.Product;
import com.ecommercecart.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getSingleProduct(Integer productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			throw new RuntimeException("Product not found exception");
	}
	
	public void deleteProduct(Integer productId) {
		Product product = getSingleProduct(productId);
		productRepository.deleteById(product.getProductId());
		
	}
	
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
