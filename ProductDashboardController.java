package com.product.product_dashboard_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product_dashboard_service.entity.Product;
import com.product.product_dashboard_service.feign.ProductClient;

@RestController
@RequestMapping("/dashboard")
public class ProductDashboardController {

	@Autowired
	private ProductClient productClient;
	
	@GetMapping("/products")
	public List<Product> getProductFromService(){
		return productClient.getAllProducts();
	}
}
