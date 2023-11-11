package com.H2PizzaProject.PizzaShop.services;

import com.H2PizzaProject.PizzaShop.model.Employee;
import com.H2PizzaProject.PizzaShop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployee(){
        return (List<Employee>) employeeRepository.findAll();
    }

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
    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "Employee got deleted";
    }
}
