package com.H2PizzaProject.PizzaShop.services;
import com.H2PizzaProject.PizzaShop.model.Customer;
import com.H2PizzaProject.PizzaShop.model.CustomerOrder;
import com.H2PizzaProject.PizzaShop.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    // Implementing the different crud operations


    // find the list of customers
    public List<CustomerOrder> getAllCustomerOrder(){
        return (List<CustomerOrder>) customerOrderRepository.findAll();
    }

    // create a customer
    public String createCustomerOrder(CustomerOrder customerOrder){
        customerOrderRepository.save(customerOrder);
        return "Customer Order added.";
    }

    // find a customer by id

    public CustomerOrder findCustomer(int id){
        return  customerOrderRepository.findById(id).orElse(null);
    }

    // update a customer

    public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder){
        // find the current customer
        Optional<CustomerOrder> optionalCustomer = customerOrderRepository.findById(customerOrder.getOrder_id());
        // make the desired changes
        CustomerOrder oldCustomer = null;
        if(optionalCustomer.isPresent()){
            oldCustomer = optionalCustomer.get();
            oldCustomer.setComplete(customerOrder.isComplete());
            oldCustomer.setCreatedAt(customerOrder.getCreatedAt());
            oldCustomer.setEmployee(customerOrder.getEmployee());
            oldCustomer.setDetails(customerOrder.getDetails());
            customerOrderRepository.save(oldCustomer);
        }else{
            return new CustomerOrder();
        }
        return oldCustomer;
    }

    public String deleteCustomerOrder(int id){
        customerOrderRepository.deleteById(id);
        return "Customer deleted";
    }
}
