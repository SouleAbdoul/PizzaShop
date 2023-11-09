package com.H2PizzaProject.PizzaShop.repository;

import com.H2PizzaProject.PizzaShop.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
