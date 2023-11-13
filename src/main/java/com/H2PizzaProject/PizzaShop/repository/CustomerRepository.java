package com.H2PizzaProject.PizzaShop.repository;

import com.H2PizzaProject.PizzaShop.model.Customer;
import org.springframework.data.repository.CrudRepository;

// This is the customer repository interface
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
   // add custom code here if needed
}
