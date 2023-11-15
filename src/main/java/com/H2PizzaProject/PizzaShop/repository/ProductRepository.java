package com.H2PizzaProject.PizzaShop.repository;

import com.H2PizzaProject.PizzaShop.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository  extends CrudRepository<Product,Integer> {
    // Interface for the Products.
}
