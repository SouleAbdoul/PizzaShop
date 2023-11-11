package com.H2PizzaProject.PizzaShop.services;

import com.H2PizzaProject.PizzaShop.model.Employee;
import com.H2PizzaProject.PizzaShop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This class is service class use the employeeRepository (Interface) and
// Implement all the basic methods (save, findall, findByid, and deleteByid) inherited from the
// employee Interface
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    // Implementation of save method.
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }


    // Implementation of the findById method for the get method
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }


    // Implementation of the findAll method.
    public List<Employee> getAllEmployee(){
        return (List<Employee>) employeeRepository.findAll();
    }

   // Implementation for the findByid for the update method.
    public Employee updateEmployee(Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployee_id());
        Employee oldEmployee = null;
        if(optionalEmployee.isPresent()){
             oldEmployee = optionalEmployee.get();
            oldEmployee.setName(employee.getName());
            oldEmployee.setEmployee_status(employee.getEmployee_status());
            employeeRepository.save(oldEmployee);
        }else{
            return new Employee();
        }
        return oldEmployee;
    }

    // Implementation of the deleteById method.
    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "Employee got deleted";
    }
}
