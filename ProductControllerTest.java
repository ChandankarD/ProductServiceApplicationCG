package com.product.productservice.controllertest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productservice.controller.ProductController;
import com.product.productservice.entity.Product;
import com.product.productservice.service.ProductService;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(ProductController.class)

public class ProductControllerTest {

	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void testCreateProduct() throws Exception {
        Product sample = new Product();
        sample.setId(1);
        sample.setProductName("Pen");
        sample.setPrice(95.5);
        sample.setQuantity(2);
        sample.setDescription("Blue Pen");

        Mockito.when(productService.createProduct(Mockito.any())).thenReturn(sample);

        mockMvc.perform(post("/basePath/v1/products/createproduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sample)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.productName").value("Pen"));
    }
    
    @Test
    void testGetAllProducts() throws Exception {
        Product sample = new Product();
        sample.setId(1);
        sample.setProductName("Shirt");
        sample.setPrice(95.5);
        sample.setQuantity(2);
        sample.setDescription("White colour Shirt");

        Mockito.when(productService.getAllProducts()).thenReturn(Arrays.asList(sample));

        mockMvc.perform(get("/basePath/v1/products/getallproducts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productName").value("Shirt"));
    }

    @Test
    void testGetProductById() throws Exception {
        Product sample = new Product();
        sample.setId(1);
        sample.setProductName("Shirt");
        sample.setPrice(95.5);
        sample.setQuantity(2);
        sample.setDescription("Shirt is order from Roadstar");

        Mockito.when(productService.getProductById(1)).thenReturn(sample);

        mockMvc.perform(get("/basePath/v1/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.productName").value("Shirt"));
    }



}
