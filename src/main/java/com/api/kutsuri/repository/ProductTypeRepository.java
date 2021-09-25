package com.api.kutsuri.repository;

import com.api.kutsuri.model.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    
}
