package com.nctech.organicstore.service.impl;

import com.nctech.organicstore.dto.Category;
import com.nctech.organicstore.repository.CategoryRepository;
import com.nctech.organicstore.repository.impl.CategoryRepositoryImpl;
import com.nctech.organicstore.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
