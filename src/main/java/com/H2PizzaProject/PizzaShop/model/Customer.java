package com.H2PizzaProject.PizzaShop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Customer {

        @Id
        @Column(name="phone_number")
        private Long phone_number;

        private String name;
        private String street_address;
        private String zip_code;

        public Customer(){}

        public Customer(Long phone_number, String name, String street_address, String zip_code) {

            this.phone_number = phone_number;
            this.name = name;
            this.street_address = street_address;
            this.zip_code = zip_code;
        }

        public Long getPhone_number() {

            return phone_number;
        }

        public void setPhone_number(Long phone_number) {

            this.phone_number = phone_number;
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

        public void setStreetAddress(String street_address) {
            this.street_address = street_address;
        }

        public String getZipCode() {
            return zip_code;
        }

        public void setZipCode(String zip_code) {
            this.zip_code = zip_code;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", address='" + street_address + '\'' +
                    ", zip='" + zip_code + '\'' + '}';
        }
    }


