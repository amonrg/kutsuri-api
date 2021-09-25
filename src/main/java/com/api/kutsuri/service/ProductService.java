package com.api.kutsuri.service;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.Product;

public interface ProductService {
    Product add(Product product);
    List<Product> getAll();
    Optional<Product> getProductById(int id);
    void deleteProductById(int id);
    Product updateProduct(int id, Product productDetails);
}
