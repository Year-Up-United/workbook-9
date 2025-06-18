package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CategoryDAO {
    List<Category> getAllCategories();
    Category getCategoryById(int categoryId);
    void addCategory(Category category);

}
