package com.H2PizzaProject.PizzaShop.controller;

import com.H2PizzaProject.PizzaShop.model.Customer;
import com.H2PizzaProject.PizzaShop.model.CustomerOrder;
import com.H2PizzaProject.PizzaShop.model.Employee;
import com.H2PizzaProject.PizzaShop.model.OrderDetail;
import com.H2PizzaProject.PizzaShop.services.CustomerOrderService;
import com.H2PizzaProject.PizzaShop.services.CustomerService;
import com.H2PizzaProject.PizzaShop.services.EmployeeService;
import com.H2PizzaProject.PizzaShop.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderDetailService orderDetailService;

    // EndPoint to get all employees
    // added other endpoints
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/customerOrder")
    public Iterable<CustomerOrder> getAllCustomerOrder() {
        return customerOrderService.getAllCustomerOrder();
    }
    // EndPoint to add a new employee

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addNewOrder")
    public CustomerOrder addEmployee(@RequestBody CustomerOrder customerOrder){
        return customerOrderService.createCustomerOrder(customerOrder);
    }


    // EndPoint to update an employee
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    @PutMapping("/updateCustomerOrder")
    public CustomerOrder updateEmployee(@RequestBody CustomerOrder customerOrder){
        return customerOrderService.updateCustomerOrder(customerOrder);
    }

    // get Customer Order By id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/customerOrder/{id}")
    public  CustomerOrder findCustomerOrderByid(@PathVariable int id){
       return customerOrderService.findCustomerOrder(id);
    }

    // EndPoint to delete employee
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteCustomerOrder/{id}")
    public String deleteEmployee(@PathVariable int id){
        return customerOrderService.deleteCustomerOrder(id);
    }



    // Here are the special purpose EndPoints.
    //get order made by a particular employee by using his employee_id as path parameter
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getOrderByEmployeeId/{id}")
    public List<CustomerOrder> getAllOrderByEmployeeId(@PathVariable int id){
        return customerOrderService.getOrderByEmployee(id);
    }

    // get order made by a specific customer by using his phone_number
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getOrderByCustomer/{phone_number}")
    public List<CustomerOrder> getAllOrderByPhoneNumber(@PathVariable Long phone_number){
        return customerOrderService.getOrderByCustomer(phone_number).isEmpty() ? null: customerOrderService.getOrderByCustomer(phone_number);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getOrderByZipCode/{zipCode}")
    public List<CustomerOrder> getAllOrderByZipcode(@PathVariable String zipCode){
        List<CustomerOrder> orders = customerOrderService.getAllCustomerOrder();
        var newList = orders.stream().filter(order -> customerOrderService.compareZipCode(order,zipCode)).toList();
        return newList;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getOrderByWeek/{day}")
    public List<CustomerOrder> getAllOrderByWeek(@PathVariable("day") String Sdate){
        LocalDateTime date = LocalDateTime.parse(Sdate);
        List<CustomerOrder>   orders = customerOrderService.getAllCustomerOrder();
        var newList = orders.stream().filter(order-> compareDate(order.getCreatedAt(),date)).toList();
        return newList;
    }

    private boolean compareDate(LocalDateTime createdAt, LocalDateTime date) {
        return createdAt.isBefore(date.plusDays(1)) || createdAt.isBefore(date.plusDays(2)) || createdAt.isBefore(date.plusDays(3))
                || createdAt.isBefore(date.plusDays(4)) || createdAt.isBefore(date.plusDays(5)) || createdAt.isBefore(date.plusDays(6))
                || createdAt.isBefore(date.plusDays(7));
    }
}

