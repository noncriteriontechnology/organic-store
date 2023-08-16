package com.nctech.organicstore.repository.impl;

import com.nctech.organicstore.config.DBConfig;
import com.nctech.organicstore.dto.Category;
import com.nctech.organicstore.dto.Product;
import com.nctech.organicstore.dto.Product;
import com.nctech.organicstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private DBConfig dbConfig;

    @Override
    public Product save(Product product) {
        String sql = "INSERT INTO PRODUCT (ID, NAME, CATEGORY_ID, PRICE, UNIT_TYPE, IS_AVAILABLE, DISCOUNT) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getCategory().getId());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getUnit());
            preparedStatement.setBoolean(6, product.getAvailable());
            preparedStatement.setFloat(7, product.getDiscount());
            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;


    }

    @Override
    public Product update(Product product) {
        String sql = "UPDATE PRODUCT  SET NAME = ?, CATEGORY_ID = ?, PRICE = ?, UNIT_TYPE = ?, IS_AVAILABLE = ?, DISCOUNT = ? WHERE ID = ?";
        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(7, product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategory().getId());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getUnit());
            preparedStatement.setBoolean(5, product.getAvailable());
            preparedStatement.setFloat(6, product.getDiscount());
            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }

    @Override
    public Product findById(Integer id) {
        String sql = "SELECT * FROM  PRODUCT WHERE ID =?";
        Product product = new Product();
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));

                Category category = new Category();
                category.setId(resultSet.getInt("CATEGORY_ID"));
                product.setCategory(category);

                product.setUnit(resultSet.getString("UNIT_TYPE"));
                product.setAvailable(resultSet.next());
                product.setDiscount((Float) resultSet.getObject("DISCOUNT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM PRODUCT";
        List<Product> products = new ArrayList<>();
        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));

                Category category = new Category();
                category.setId(resultSet.getInt("CATEGORY_ID"));
                product.setCategory(category);

                product.setUnit(resultSet.getString("UNIT_TYPE"));
                product.setAvailable(resultSet.next());
                product.setDiscount((Float) resultSet.getObject("DISCOUNT"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM PRODUCT WHERE ID=?";
        try (Connection connection = dbConfig.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            System.out.println(result + " Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
