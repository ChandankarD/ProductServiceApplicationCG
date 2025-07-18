package com.product.product_dashboard_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.product.product_dashboard_service")
public class ProductDashboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDashboardServiceApplication.class, args);
	}

}
