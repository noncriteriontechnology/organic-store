package com.nctech.organicstore.repository.impl;

import com.nctech.organicstore.config.DBConfig;
import com.nctech.organicstore.dto.Category;
import com.nctech.organicstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private DBConfig dbConfig;

    @Override
    public Category save(Category category) {

        String sql = "INSERT INTO CATEGORY (ID, NAME, CODE) VALUES (?, ?, ?)";

        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getCode());
            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category update(Category category) {
        String sql = "UPDATE CATEGORY SET NAME=?, CODE=? WHERE ID=?";
        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(3, category.getId());
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getCode());
            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category findById(Integer id) {
        String sql = "SELECT * FROM CATEGORY WHERE ID=?";
        Category category = new Category();
        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category.setId(resultSet.getInt("ID"));
                category.setName(resultSet.getString("NAME"));
                category.setCode(resultSet.getString("CODE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM CATEGORY";
        List<Category> categories = new ArrayList<>();
        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("ID"));
                category.setName(resultSet.getString("NAME"));
                category.setCode(resultSet.getString("CODE"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM CATEGORY WHERE ID=?";
        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            System.out.println(result + " Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
