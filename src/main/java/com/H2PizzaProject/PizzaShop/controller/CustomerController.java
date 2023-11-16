package com.H2PizzaProject.PizzaShop.controller;

import com.H2PizzaProject.PizzaShop.model.Customer;
import com.H2PizzaProject.PizzaShop.services.CustomerService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //End point to get all the customers
   @ResponseStatus(HttpStatus.OK)
    @GetMapping("/customers")
    public  Iterable<Customer> getAllCustomers(){
      return customerService.getAllCustomer();
    }

    // EndPoint to add a new customer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
       return customerService.createCustomer(customer);
    }

    @ResponseStatus(HttpStatus.RESET_CONTENT)
    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer){
       return customerService.updateCustomer(customer);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/customers/{id}")
    public Customer findCustomer(@PathVariable long id){
        return   customerService.findCustomer(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
       return customerService.deleteCustomer(id);
    }

}