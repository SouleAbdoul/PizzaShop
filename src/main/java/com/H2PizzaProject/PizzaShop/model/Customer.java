package com.H2PizzaProject.PizzaShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class Customer {

        @Id
        @Column(name="phone_number",columnDefinition = "LONG")
        private Long phone_number;
        private String name;
        private String street_address;
        private String zip_code;

    // for the one-to-many relationships
        @JsonIgnore
        @OneToMany(mappedBy = "customer")
        private Set<CustomerOrder>  myOrders = new HashSet<>();

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

        public String getStreet_address() {
            return street_address;
        }

        public void setStreet_address(String street_address) {
            this.street_address = street_address;
        }

        public String getZip_code() {
            return zip_code;
        }

        public void setZip_code(String zip_code) {
            this.zip_code = zip_code;
        }
        public Set<CustomerOrder> getMyOrders() {
         return myOrders;
        }
        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", address='" + street_address + '\'' +
                    ", zip='" + zip_code + '\'' + '}';
        }
    }


