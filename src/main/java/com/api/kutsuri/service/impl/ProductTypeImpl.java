package com.api.kutsuri.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.ProductType;
import com.api.kutsuri.repository.ProductTypeRepository;
import com.api.kutsuri.service.ProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeImpl implements ProductTypeService {

    ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductType add(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> getProductTypeById(int id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public void deleteProductTypeById(int id) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow();
        productTypeRepository.delete(productType);
    }

    @Override
    public ProductType updateProductType(int id, ProductType productTypeDetails) {
        ProductType productType = productTypeRepository.getById(id);

        productType.setName(productTypeDetails.getName());

        return productTypeRepository.save(productType);
    }
    
}
