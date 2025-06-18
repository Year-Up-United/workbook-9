package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDAO implements CategoryDAO {

    private DatabaseConfig databaseConfig;

    @Autowired
    public JdbcCategoryDAO(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }


    @Override
    public List<Category> getAllCategories() {

        ArrayList<Category> categories = new ArrayList<>();

        String query = """
                 SELECT
                                CategoryId,
                                CategoryName
                                from
                                Categories
                """;

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseConfig.getUrl());
        basicDataSource.setUsername(databaseConfig.getUsername());
        basicDataSource.setPassword(databaseConfig.getPassword());

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                int CategoryId = resultSet.getInt(1);
                String CategoryName = resultSet.getString(2);
                Category c = new Category(CategoryId, CategoryName);
                categories.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return null;
    }

    public List<Category> getCategoryById() {

            ArrayList<Category> categories = new ArrayList<>();

            String query = """
                 SELECT
                                CategoryId,
                                from
                                Categories
                """;

            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(databaseConfig.getUrl());
            basicDataSource.setUsername(databaseConfig.getUsername());
            basicDataSource.setPassword(databaseConfig.getPassword());

            try(
                    Connection connection = basicDataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery();)
            {
                while(resultSet.next()){
                    int CategoryId = resultSet.getInt(1);
                    String CategoryName = resultSet.getString(2);
                    Category c = new Category(CategoryId, CategoryName);
                    categories.add(c);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return categories;
    }
    @Override
    public void addCategory(Category category) {

    }
}
