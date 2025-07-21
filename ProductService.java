/*package com.product.product_dashboard_service.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product_dashboard_service.entity.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductService {
	
	@Autowired
	private ProductClient productClient;
	

	
	//circuit breaker applied to feign client call when product service is down this fails
	
	
	@CircuitBreaker(name= "productservice", fallbackMethod="reliable")
	public List<Product> getAllProducts(){
		return productClient.getAllProducts();
	}
	
	
	//fallback method
	
	public List<Product> reliable(Throwable t){
		System.out.println("fallback triggered" + t.getMessage());
		
		Product dummy= new Product(0, "Default product", 0, 0.0, "fallback product");
		return List.of(dummy);
	}

}*/
