package com.product.product_dashboard_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.product.product_dashboard_service.entity.Product;

@FeignClient(name="productservice", path="/basePath/v1/products")
public interface ProductClient {

	@GetMapping("/getallproducts")
	List<Product>getAllProducts();
}
