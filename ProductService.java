package com.product.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productservice.entity.Product;
import com.product.productservice.exception.ProductNotFoundException;
import com.product.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository repo;

    public Product createProduct(Product p) {
        return repo.save(p);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product not found with ID " + id));
    }


}
