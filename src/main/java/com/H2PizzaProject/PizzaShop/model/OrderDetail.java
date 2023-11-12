package com.H2PizzaProject.PizzaShop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Entity
@Data
public class OrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int detail_id;
        private double priceCharged;
        private int quantity;
        private Product product;

        public OrderDetail(){}

        public OrderDetail(int detail_id, double priceCharged, int quantity, Product product) {
            this.detail_id = detail_id;
            this.priceCharged = priceCharged;
            this.quantity = quantity;
            this.product = product;
        }

        public int getDetail_id() {
            return detail_id;
        }

        public void setDetail_id(int detail_id) {
            this.detail_id = detail_id;
        }

        public double getPriceCharged() {
            return priceCharged;
        }

        public void setPriceCharged(double priceCharged) {
            this.priceCharged = priceCharged;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        @Override
        public String toString() {
            return "OrderDetail{" +
                    "detail_id=" + detail_id +
                    ", priceCharged=" + priceCharged +
                    ", quantity=" + quantity +
                    ", product=" + product +
                    '}';
        }
    }

