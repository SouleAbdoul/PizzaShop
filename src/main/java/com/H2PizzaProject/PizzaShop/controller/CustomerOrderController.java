package com.H2PizzaProject.PizzaShop.controller;

import com.H2PizzaProject.PizzaShop.model.CustomerOrder;
import com.H2PizzaProject.PizzaShop.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    // EndPoint to get all employees
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/employees")
    public Iterable<CustomerOrderService> getAllEmployee() {
        return customerOrderService.getAllCustomerOrder();
    }

    // EndPoint to add a new employee
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addOrderService")
    public CustomerOrderService addEmployee(@RequestBody CustomerOrderService employee){
        return customerOrderService.createCustomerOrder(employee);
    }


    // EndPoint to update an employee
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    @PutMapping("/updateEmployee")
    public CustomerOrderService updateEmployee(@RequestBody CustomerOrderService employee){
        return customerOrderService.updateEmployee(employee);
    }



    // EndPoint to delete employee
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return customerOrderService.deleteEmployee(id);
    }

}

}
