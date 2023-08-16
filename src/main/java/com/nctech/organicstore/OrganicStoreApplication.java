package com.nctech.organicstore;

import com.nctech.organicstore.config.AppConfig;
import com.nctech.organicstore.controller.CategoryController;
import com.nctech.organicstore.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class OrganicStoreApplication {

    private Category category;
    public static void main(String[] args) {
        OrganicStoreApplication organicStoreApplication = new OrganicStoreApplication();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CategoryController controller = context.getBean(CategoryController.class);
        organicStoreApplication.save(controller);
        organicStoreApplication.update(controller);
        organicStoreApplication.findByID(controller);
        organicStoreApplication.findAll(controller);
        organicStoreApplication.delete(controller);
    }

    public void save(CategoryController controller) {
        this.category = new Category();
        this.category.setId(10);
        this.category.setName("Fruits");
        this.category.setCode("F101");
        Category result = controller.save(this.category);
        System.out.println(result);
    }

    public void update(CategoryController controller) {
        this.category = new Category();
        this.category.setId(10);
        this.category.setName("Vegetables");
        this.category.setCode("V102");
        Category result = controller.update(this.category);
        System.out.println(result);
    }

    public void findByID(CategoryController controller) {
        Category result = controller.findById(10);
        System.out.println(result);
    }

    public void findAll(CategoryController controller) {
        List<Category> result = controller.findAll();
        System.out.println(result);
    }

    public void delete(CategoryController controller) {
        controller.delete(10);
    }
}
