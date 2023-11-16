package com.H2PizzaProject.PizzaShop.services;

import com.H2PizzaProject.PizzaShop.model.Customer;
import com.H2PizzaProject.PizzaShop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    // Import the customer repository
    @Autowired
    private CustomerRepository customerRepository;

    // Implementing the different crud operations


    // find the list of customers
    public List<Customer> getAllCustomer(){
        return (List<Customer>) customerRepository.findAll();
    }

    // create a customer
    public String createCustomer(Customer customer){
        customerRepository.save(customer);
        return "Customer added.";
    }

    // find a customer by id

    public Customer findCustomer(long id){
        return  customerRepository.findById(id).orElse(null);
    }

   // update a customer

    public Customer updateCustomer(Customer customer){
        // find the current customer
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getPhone_number());
        // make the desired changes
         Customer oldCustomer = null;
         if(optionalCustomer.isPresent()){
             oldCustomer = optionalCustomer.get();
             oldCustomer.setPhone_number(customer.getPhone_number());
             oldCustomer.setName(customer.getName());
             oldCustomer.setStreetAddress(customer.getStreetAddress());
             oldCustomer.setZipCode(customer.getZipCode());
             customerRepository.save(oldCustomer);
         }else{
             return new Customer();
         }
        return oldCustomer;
    }

    public String deleteCustomer(long id){
        customerRepository.deleteById(id);
        return "Customer deleted";
    }
}

