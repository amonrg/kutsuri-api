package com.api.kutsuri.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.kutsuri.model.Product;
import com.api.kutsuri.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping("/products")
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable(name = "id") int id) {
        return productService.getProductById(id).orElseThrow();
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(name = "id") int id,
                                 @Valid @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
