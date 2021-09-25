package com.api.kutsuri.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.Product;
import com.api.kutsuri.repository.ProductRepository;
import com.api.kutsuri.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(int id, Product productDetails) {
        Product product = productRepository.getById(id);

        product.setAvailability(productDetails.getAvailability());
        product.setBrand(productDetails.getBrand());
        product.setColor(productDetails.getColor());
        product.setModel(productDetails.getModel());
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setSize(productDetails.getSize());
        product.setType(productDetails.getType());

        return productRepository.save(product);
    }
    
}
