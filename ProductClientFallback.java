package com.product.product_dashboard_service.feign;

import java.util.List;

import org.springframework.stereotype.Component;

import com.product.product_dashboard_service.entity.Product;

@Component
public class ProductClientFallback implements ProductClient{
	@Override
	public List<Product> getAllProducts() {
		System.out.println(" Fallback method triggered- returening default products");
		
		Product dummy= new Product(0, "Default product", 0, 0.0, "fallback product");
		return List.of(dummy);
	}
}
