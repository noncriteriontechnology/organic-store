package com.nctech.organicstore.repository.impl;

import com.nctech.organicstore.config.DBConfig;
import com.nctech.organicstore.dto.Category;
import com.nctech.organicstore.repository.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    DBConfig dbConfig = new DBConfig();

    @Override
    public Category save(Category category) {

        String sql = "INSERT INTO CATEGORY (ID, NAME, CODE) VALUES (?, ?, ?)";

        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getCode());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category findById(Integer integer) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
