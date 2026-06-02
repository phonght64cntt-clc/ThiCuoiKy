package com.bake.bake_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bake.bake_backend.entity.Category;
import com.bake.bake_backend.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }
}