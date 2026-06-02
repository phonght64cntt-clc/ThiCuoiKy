package com.bake.bake_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bake.bake_backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByIsActiveTrue();
}