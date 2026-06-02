package com.bake.bake_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bake.bake_backend.entity.Product;
import com.bake.bake_backend.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findByIsActiveTrue();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm id: " + id));
    }

    public List<Product> getByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product updated) {
        Product product = getById(id);
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());
        product.setImage(updated.getImage());
        product.setCategory(updated.getCategory());
        product.setIsActive(updated.getIsActive());
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}