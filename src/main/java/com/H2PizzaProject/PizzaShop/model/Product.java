package com.H2PizzaProject.PizzaShop.model;

public enum Product {

    SODA(1, "Soda", 3.25, "2 Liter bottle"),
    BREADSTICKS(2, "Breadsticks", 2.50, "8 per pack"),
    PIZZA_SMALLPEPPERONI(3, "Pizza - small Pepperoni", 7.35, "8 inch"),
    PIZZA_MEDIUMPEPPERONI(4, "Pizza - medium Pepperoni", 9.35, "12 inch"),
    PIZZA_LARGEPEPPERONI(5, "Pizza - large Pepperoni", 14.00, "18 inch"),
    PIZZA_SMALLHOUSESPECIAL(6, "Pizza - small house special", 8.50, "8 inch"),
    PIZZA_MEDIUMHOUSESPECIAL(7, "Pizza - medium house special", 10.50, "12 inch"),
    PIZZA_LARGEHOUSESPECIAL(8, "Pizza - large house special", 16.00, "18 inch");
    private final int product_id;
    private final String name;
    private final double price;
    private final String size;

    Product(int product_id, String name, double price, String size) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.size = size;
    }
}
