package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Shirt", 2, 5.99));
        return products;

    }

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public List<Product> getProducts(@PathVariable int productId) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Shirt", 2, 5.99));

        for (Product p : products) {
            if (p.getProductId() == productId) {
                ArrayList<Product> resultingProducts = new ArrayList<>();
                resultingProducts.add(p);
                return resultingProducts;
            }
        }

        return new ArrayList<Product>();

    }
}
