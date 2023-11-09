package com.H2PizzaProject.PizzaShop.model;

import org.springframework.data.annotation.Id;

public class Employee {
    private @Id int employee_id;
    private String name;
    private String employee_status;
    private String employee_role;
    public Employee(){}

    public Employee(int employee_id, String name, String employee_status, String employee_role) {
        this.employee_id = employee_id;
        this.name = name;
        this.employee_status = employee_status;
        this.employee_role = employee_role;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee_status() {
        return employee_status;
    }

    public void setEmployee_status(String employee_status) {
        this.employee_status = employee_status;
    }

    public String getEmployee_role() {
        return employee_role;
    }

    public void setEmployee_role(String employee_role) {
        this.employee_role = employee_role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employee_status='" + employee_status + '\'' +
                ", employee_role='" + employee_role + '\'' +
                '}';
    }
}
