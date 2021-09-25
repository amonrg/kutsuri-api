package com.api.kutsuri.service;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.ProductType;

public interface ProductTypeService {
    ProductType add(ProductType productType);
    List<ProductType> getAll();
    Optional<ProductType> getProductTypeById(int id);
    void deleteProductTypeById(int id);
    ProductType updateProductType(int id, ProductType productTypeDetails);
}
