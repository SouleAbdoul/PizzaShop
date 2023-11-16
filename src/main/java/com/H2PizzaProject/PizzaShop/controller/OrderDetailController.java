package com.H2PizzaProject.PizzaShop.controller;


import com.H2PizzaProject.PizzaShop.model.OrderDetail;
import com.H2PizzaProject.PizzaShop.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderdetailService;

    //End point to get all the orders
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/orders")
    public  Iterable<OrderDetail> getAllOrders(){
        return orderdetailService.getAllOrders();
    }


    // EndPoint to add a new order

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addOrder")
    public String addOrder(@RequestBody OrderDetail order){
        return orderdetailService.createOrder(order);
    }

    @ResponseStatus(HttpStatus.RESET_CONTENT)
    @PutMapping("/updateOrder")
    public OrderDetail updateOrder(@RequestBody OrderDetail order){
        return orderdetailService.updateOrder(order);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/getOrder/{id}")
    public String findOrder(@PathVariable int id){
        orderdetailService.findOrder(id);
        return "Found";
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id){
        return orderdetailService.deleteOrder(id);
    }

}