package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class SimpleProductDAO implements ProductDAO {

    public List<Product> getAllProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Shirt", 2, 5.99));
        return products;

    }
    @Override
    public Product getProductById(int productID){
        List<Product> allProducts = getAllProducts();
        return allProducts.stream().filter(p -> p.getProductId() == productID).findFirst().orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        // do nothing
        return new Product();
    }
}
