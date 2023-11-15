package com.H2PizzaProject.PizzaShop.controller;

// This class is to set all the endpoints for the employees crud operations
import com.H2PizzaProject.PizzaShop.model.Employee;
import com.H2PizzaProject.PizzaShop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    // EndPoint to get all employees
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployee() {
            return employeeService.getAllEmployee();
    }

    // EndPoint to add a new employee
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }


    // EndPoint to update an employee
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    // EndPoint to delete employee
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

}
