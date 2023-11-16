package com.H2PizzaProject.PizzaShop.controller;

import com.H2PizzaProject.PizzaShop.model.CustomerOrder;
import com.H2PizzaProject.PizzaShop.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    // EndPoint to get all employees
    // added other endpoints
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/customerOrder")
    public Iterable<CustomerOrder> getAllCustomerOrder() {
        return customerOrderService.getAllCustomerOrder();
    }

    // EndPoint to add a new employee
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addCustomerOrder")
    public CustomerOrder addEmployee(@RequestBody CustomerOrder customerOrder){
        return customerOrderService.createCustomerOrder(customerOrder);
    }


    // EndPoint to update an employee
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    @PutMapping("/updateCustomerOrder")
    public CustomerOrder updateEmployee(@RequestBody CustomerOrder customerOrder){
        return customerOrderService.updateCustomerOrder(customerOrder);
    }



    // EndPoint to delete employee
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteCustomerOrder/{id}")
    public String deleteEmployee(@PathVariable int id){
        return customerOrderService.deleteCustomerOrder(id);
    }

}

