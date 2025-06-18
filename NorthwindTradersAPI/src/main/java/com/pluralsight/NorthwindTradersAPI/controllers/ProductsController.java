package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.ProductDAO;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    private ProductDAO productDAO;

    @Autowired
    public ProductsController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {

        return productDAO.getAllProducts();

    }

    @RequestMapping(path = "/products/byId/{productId}", method = RequestMethod.GET)
    public Product getProductsById(@PathVariable int productId) {
        return productDAO.getProductById(productId);
        }
    @RequestMapping(path = "/products", method= RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        productDAO.addProduct(product);
        return productDAO.addProduct(product);
    }

    }
