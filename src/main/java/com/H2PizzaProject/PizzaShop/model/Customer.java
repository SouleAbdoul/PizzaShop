package com.H2PizzaProject.PizzaShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;
@Entity
@Data
public class Customer {

        @Id
        private int phone_number;
        private String name;
        private String street_address;
        private String zip_code;

        public Customer(){}

        public Customer(int customer_id, String name, String street_address, String zip_code) {
            this.phone_number = customer_id;
            this.name = name;
            this.street_address = street_address;
            this.zip_code = zip_code;
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
            return street_address;
        }

        public void setStreetAddress(String address) {
            this.street_address = address;
        }

        public String getZipCode() {
            return zip_code;
        }

        public void setZipCode(String zipcode) {
            this.zip_code = zipcode;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", address='" + street_address + '\'' +
                    ", zip='" + zip_code + '\'' + '}';
        }
    }


