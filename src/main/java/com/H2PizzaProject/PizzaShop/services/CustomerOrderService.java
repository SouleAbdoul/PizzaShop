package com.H2PizzaProject.PizzaShop.services;
import com.H2PizzaProject.PizzaShop.model.Customer;
import com.H2PizzaProject.PizzaShop.model.CustomerOrder;
import com.H2PizzaProject.PizzaShop.model.Employee;
import com.H2PizzaProject.PizzaShop.model.OrderDetail;
import com.H2PizzaProject.PizzaShop.repository.CustomerOrderRepository;
import com.H2PizzaProject.PizzaShop.repository.CustomerRepository;
import com.H2PizzaProject.PizzaShop.repository.EmployeeRepository;
import com.H2PizzaProject.PizzaShop.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    // Implementing the different crud operations

    @Autowired
    private CustomerRepository customerRepository;


    // find the list of customers
    public List<CustomerOrder> getAllCustomerOrder(){
        return (List<CustomerOrder>) customerOrderRepository.findAll();
    }

    // create a new order
    public CustomerOrder createCustomerOrder(CustomerOrder customerOrder){

        Employee employee = employeeRepository.findById(customerOrder.getEmployee().getEmployee_id())
                .orElse(new Employee());
        customerOrder.setEmployee(employee);
        Customer customer = customerRepository.findById(customerOrder.getCustomer().getPhone_number()).orElse(new Customer());
        customerOrder.setCustomer(customer);

       CustomerOrder savedCustomerOrder1 =  customerOrderRepository.save(customerOrder);

        System.out.println(customerOrder);

        return savedCustomerOrder1;
    }

    // find a customer by id

    public CustomerOrder findCustomerOrder(int id){

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
            oldCustomer.setOrder_status(customerOrder.getOrder_status());
            oldCustomer.setTimestamp(customerOrder.getTimestamp());
            oldCustomer.setEmployee(customerOrder.getEmployee());
            //oldCustomer.setDetails(customerOrder.getDetails());
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
