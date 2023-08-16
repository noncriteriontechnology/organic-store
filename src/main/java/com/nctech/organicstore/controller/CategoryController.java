package com.nctech.organicstore.controller;

import com.nctech.organicstore.dto.Category;
import com.nctech.organicstore.service.CategoryService;
import com.nctech.organicstore.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public Category save(Category category) {
        return categoryService.save(category);
    }

    public Category update(Category category) {
        return categoryService.update(category);
    }

    public Category findById(Integer id) {
        return categoryService.findById(id);
    }

    public List<Category> findAll() {
        return categoryService.findAll();
    }

    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
