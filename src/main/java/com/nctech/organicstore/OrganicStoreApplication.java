package com.nctech.organicstore;

import com.nctech.organicstore.controller.CategoryController;
import com.nctech.organicstore.dto.Category;

public class OrganicStoreApplication {
    public static void main(String[] args)  {
        CategoryController controller = new CategoryController();
        Category category = new Category();
        category.setId(7);
        category.setName("Fruits");
        category.setCode("F101");
        Category result = controller.save(category);
        System.out.println(result);
    }
}
