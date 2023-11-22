package com.H2PizzaProject.PizzaShop.controller;

import com.H2PizzaProject.PizzaShop.model.Product;
import com.H2PizzaProject.PizzaShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> getAll() {
         return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Product getProductByid(@PathVariable int id){
        return productService.getProductByid(id);
    }
}
