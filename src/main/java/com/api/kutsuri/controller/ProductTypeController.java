package com.api.kutsuri.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.kutsuri.model.ProductType;
import com.api.kutsuri.service.ProductTypeService;

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
public class ProductTypeController {
    ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/producttypes")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAll();
    }

    @PostMapping("/producttypes")
    public ProductType addProductType(@Valid @RequestBody ProductType productType) {
        return productTypeService.add(productType);
    }

    @GetMapping("/producttypes/{id}")
    public ProductType getProductTypeById(@PathVariable(name = "id") int id) {
        return productTypeService.getProductTypeById(id).orElseThrow();
    }

    @PutMapping("/producttypes/{id}")
    public ProductType updateProductType(@PathVariable(name = "id") int id,
                                         @Valid @RequestBody ProductType productTypeDetails) {
        return productTypeService.updateProductType(id, productTypeDetails);
    }

    @DeleteMapping("/producttypes/{id}")
    public ResponseEntity<?> deleteProductType(@PathVariable(name = "id") int id) {
        productTypeService.deleteProductTypeById(id);
        return ResponseEntity.ok().build();
    }
}
