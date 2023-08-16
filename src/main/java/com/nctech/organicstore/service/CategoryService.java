package com.nctech.organicstore.service;

import com.nctech.organicstore.dto.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Category update(Category category);

    Category findById(Integer id);

    List<Category> findAll();

    void delete(Integer id);
}
