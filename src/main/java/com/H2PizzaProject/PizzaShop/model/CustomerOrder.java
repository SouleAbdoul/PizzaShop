package com.H2PizzaProject.PizzaShop.model;
import java.sql.Timestamp;
import java.util.*;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Data;

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

        @Temporal(TemporalType.TIMESTAMP)
        public Timestamp getTimestamp() {
        return timestamp;
    }

        //@ManyToOne(cascade = CascadeType.MERGE)
        //@JoinColumn(name="detail_id",referencedColumnName = "detail_id")
        //private OrderDetail orderDetails;

        private boolean order_status;
        @Temporal(TemporalType.TIMESTAMP)
        private Timestamp timestamp;


        public CustomerOrder(){}

        public CustomerOrder(Customer customer, Employee employee,Timestamp timestamp,OrderDetail orderDetails){
            this.customer = customer;
            this.employee = employee;
            this.order_status = false;
            this.timestamp = timestamp;
            //this.orderDetails = orderDetails ;
        }


    public boolean getOrder_status() {
        return order_status;
    }

    public void setOrder_status(boolean order_status) {
        this.order_status = order_status;
    }

    //public OrderDetail getOrderDetails_id() {
     //   return orderDetails;
    //}

    //public void setOrderDetails_id(OrderDetail orderDetails) {
     //   this.orderDetails = orderDetails;
    //}

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
                ", timestamp=" + timestamp +
                '}';
    }
}
