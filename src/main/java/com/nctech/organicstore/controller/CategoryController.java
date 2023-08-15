package com.nctech.organicstore.controller;

import com.nctech.organicstore.dto.Category;
import com.nctech.organicstore.service.CategoryService;
import com.nctech.organicstore.service.impl.CategoryServiceImpl;

public class CategoryController {
    CategoryService categoryService = new CategoryServiceImpl();

    public Category save(Category category) {
        return categoryService.save(category);
    }
}
