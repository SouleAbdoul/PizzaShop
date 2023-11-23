package com.H2PizzaProject.PizzaShop.model;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

@Entity
@Data
@Table
public class CustomerOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int order_id;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="phone_number",referencedColumnName = "phone_number",columnDefinition = "LONG")
        private Customer customer;

        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name="employee_id",referencedColumnName = "employee_id")
        private Employee employee;
        @CreationTimestamp
        private LocalDateTime createdAt;

        private boolean order_status;

        public CustomerOrder(){}

        public CustomerOrder(Customer customer, Employee employee){
            this.customer = customer;
            this.employee = employee;
            this.order_status = false;
        }
        public LocalDateTime getCreatedAt() {
        return this.createdAt;
        }

        public void setCreatedAt(LocalDateTime newT){
            this.createdAt = newT;
        }
        public boolean getOrder_status() {
        return order_status;
    }

        public void setOrder_status(boolean order_status) {
        this.order_status = order_status;
    }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        @Override
        public String toString() {
            return "CustomerOrder{" +
                "order_id=" + order_id +
                ", customer=" + customer +
                ", employee=" + employee +
                ", order_status=" + order_status +
                ", timestamp=" + createdAt +
                '}';
    }
}
