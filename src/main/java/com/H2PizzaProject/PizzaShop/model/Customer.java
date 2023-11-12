package com.H2PizzaProject.PizzaShop.model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Entity
@Data
public class Customer {

        @Id
        private int phone_number;
        private String name;
        private String streetAddress;
        private String zipCode;

        public Customer(){}

        public Customer(int customer_id, String name, String streetAddress, String zipCode) {
            this.phone_number = customer_id;
            this.name = name;
            this.streetAddress = streetAddress;
            this.zipCode = zipCode;
        }

        public int getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(int id) {
            phone_number = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String address) {
            this.streetAddress = address;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zip) {
            this.zipCode = zip;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", address='" + streetAddress + '\'' +
                    ", zip='" + zipCode + '\'' + '}';
        }
    }


