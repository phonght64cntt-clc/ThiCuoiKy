package com.bake.bake_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bake.bake_backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}