package com.H2PizzaProject.PizzaShop.services;

import com.H2PizzaProject.PizzaShop.model.Customer;
import com.H2PizzaProject.PizzaShop.model.OrderDetail;
import com.H2PizzaProject.PizzaShop.repository.CustomerRepository;
import com.H2PizzaProject.PizzaShop.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderdetailRepository;

    // Implementing the different CRUD operations

    // find the list of orders
    public List<OrderDetail> getAllOrders(){
        return (List<OrderDetail>) orderdetailRepository.findAll();

    }

    // create a customer
    public String createOrder(OrderDetail order){
        orderdetailRepository.save(order);
        return "Order added.";
    }

    // find order by order ID
    public OrderDetail findOrder(int orderID){
        return  orderdetailRepository.findById(orderID).orElse(null);
    }

    // update an order

    public OrderDetail updateOrder(OrderDetail order){
        // find the current order
        Optional<OrderDetail> optionalOrder = orderdetailRepository.findById(order.getDetail_id());
        // make the desired changes
        OrderDetail oldOrder = null;
        if(optionalOrder.isPresent()){
            oldOrder = optionalOrder.get();
            oldOrder.setProduct_ids(order.getProduct_ids());
            oldOrder.setQuantity(order.getQuantity());
            oldOrder.setPriceCharged(order.getPriceCharged());
            orderdetailRepository.save(oldOrder);
        }else{
            return new OrderDetail();
        }
        return oldOrder;
    }

    public String deleteOrder(int id){
        orderdetailRepository.deleteById(id);
        return "Order deleted";
    }
}

