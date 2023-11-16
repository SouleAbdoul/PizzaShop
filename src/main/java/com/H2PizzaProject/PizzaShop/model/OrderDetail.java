package com.H2PizzaProject.PizzaShop.model;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Entity
@Data
@Table
public class OrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int detail_id;
        private double price_charged;
        private int quantity;
        private List<Integer> product_ids;

        public OrderDetail(){}

        public OrderDetail(int detail_id, double price_charged, int quantity, List<Integer> product_ids) {
            this.detail_id = detail_id;
            this.price_charged = price_charged;
            this.quantity = quantity;
            this.product_ids = product_ids;
        }

        public int getDetail_id() {
            return detail_id;
        }

        public void setDetail_id(int detail_id) {
            this.detail_id = detail_id;
        }

        public double getPriceCharged() {
            return price_charged;
        }

        public void setPriceCharged(double price_charged) {
            this.price_charged = price_charged;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

    public List<Integer> getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(List<Integer> product_ids) {
        this.product_ids = product_ids;
    }

    @Override
        public String toString() {
            return "OrderDetail{" +
                    "detail_id=" + detail_id +
                    ", priceCharged=" + price_charged +
                    ", quantity=" + quantity +
                    ", product=" + product_ids+
                    '}';
        }
    }

