package com.product.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.productservice.entity.Product;
import com.product.productservice.service.ProductService;

@RestController
@RequestMapping("/basePath/v1/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

    @PostMapping("/createproduct")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("getallproducts")
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{prodId}")
    public ResponseEntity<Product> get(@PathVariable (name = "prodId") int prodId) {
        return ResponseEntity.ok(productService.getProductById(prodId));
    }


}
