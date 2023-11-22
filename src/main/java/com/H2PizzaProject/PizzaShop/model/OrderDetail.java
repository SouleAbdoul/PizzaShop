package com.H2PizzaProject.PizzaShop.model;
import jakarta.persistence.*;
import lombok.Data;

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
    private int product_id;
    //@ManyToOne
    @JoinColumn(name = "order_id")
    private int Order_id;

    public OrderDetail() {
    }

    public OrderDetail(int detail_id, double price_charged, int product_id,int quantity,int order_id) {
        this.detail_id = detail_id;
        this.price_charged = price_charged;
        this.quantity = quantity;
        this.product_id = product_id;
        this.Order_id = order_id;
//        this.customerOrder = customerOrder;

    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public double getPrice_charged() {
        return price_charged;
    }

    public void setPrice_charged(double price_charged) {
        this.price_charged = price_charged;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return this.Order_id;
    }

    public void setOrder_id(int Order_id) {
        this.Order_id = Order_id;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "detail_id=" + detail_id +
                ", priceCharged=" + price_charged +
                ", quantity=" + quantity +
                ", product_id=" + product_id +
                '}';
    }
}