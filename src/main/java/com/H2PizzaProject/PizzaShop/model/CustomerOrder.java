package com.H2PizzaProject.PizzaShop.model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Data
public class CustomerOrder {
        @Id
        private int order_id;
        private Customer customer;
        private Employee employee;
        private boolean complete;
        private Date date;
        private Time time;
        private List<OrderDetail> details;

        public CustomerOrder(){}

        public CustomerOrder(int order_id, Customer customer, Employee employee, String date, String time){
            this.order_id = order_id;
            this.customer = customer;
            this.employee = employee;
            this.date = new Date(date);
            this.time = new Time(time);
            complete = false;
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
            return complete;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "CustomerOrder{" +
                    "order_id=" + order_id +
                    ", customer='" + customer.getName() + '\'' +
                    ", employee_id='" + employee.getEmployee_id() + '\'' +
                    ", complete=" + complete +
                    ", date=" + date +
                    ", time=" + time +
                    ", details=" + details +
                    '}';
        }
    }

