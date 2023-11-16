package com.H2PizzaProject.PizzaShop.repository;

import com.H2PizzaProject.PizzaShop.model.Employee;
import org.springframework.data.repository.CrudRepository;

// This is the repository Interface that extend an out-of-the-box class (CrudRepository)
// CrudRepository use an instance class (in our case Employee class) and an id class in this case, Integer
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    // All the basic methods(save, findAll, findById, and deleteByid) comes from CrudRepository
    // and are injected Through EmployeeRepository
}
