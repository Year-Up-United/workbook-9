package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

   @RequestMapping(path="/categories", method= RequestMethod.GET)
    public List<Category> getCategories(){
       ArrayList<Category> categories = new  ArrayList<>();
       categories.add(new Category(1,"food"));
       categories.add(new Category(1,"clothes"));
       return categories;
   }
    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public List<Category> getCategories(@PathVariable int categoryId) {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "food"));
        categories.add(new Category(1, "clothes"));

        return categories.stream().filter(c -> c.getCategoryId() == categoryId).toList();


    }
}
