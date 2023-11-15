package com.H2PizzaProject.PizzaShop.model;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CustomerOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int order_id;
        @OneToOne
        private Customer customer;

        @ManyToOne
        private Employee employee;
        private boolean order_status;

         public Date getCreatedAt() {
             return createdAt;
            }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created_at", columnDefinition = "TIMESTAMP")
        private Date createdAt;
        @OneToMany
        private List<OrderDetail> details;

        public CustomerOrder(){}

        public CustomerOrder(int order_id, Customer customer, Employee employee,Date newDate){
            this.order_id = order_id;
            this.customer = customer;
            this.employee = employee;
            this.order_status = false;
            this.createdAt = newDate;
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

        public List<OrderDetail> getDetails() {
            return details;
        }

        public void setDetails(List<OrderDetail> details) {
            this.details = details;
        }

        public boolean isComplete() {
            return this.order_status;
        }

        public void setComplete(boolean order_status) {
            this.order_status = order_status;
        }



        @Override
        public String toString() {
            return "CustomerOrder{" +
                    "order_id=" + order_id +
                    ", customer='" + customer.getName() + '\'' +
                    ", employee_id='" + employee.getEmployee_id() + '\'' +
                    ", order_status=" + order_status +
                    ", date=" + //date +
                    ", time=" + //time +
                    ", details=" + details +
                    '}';
        }
    }

