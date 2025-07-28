package ru.JavaForBeginners.attestation01;

import java.util.ArrayList;

public class Person {
    private String name;
    private int moneyAmount;
    private ArrayList <Product> products;

    Person(String name, int moneyAmount) {
        this.name = name;
        this.moneyAmount = moneyAmount;
        this.products = new ArrayList<Product>();
    }

    Person(String name) {
        this.name = name;
        this.moneyAmount = 0;
        this.products = new ArrayList<Product>();
    }

    public String getName() {
        return name;
    }

    public void buy(Product product) {
        if (this.moneyAmount >= product.getPrice()) {
            this.moneyAmount -= product.getPrice();
            this.products.add(product);
            System.out.println(this.name + " купил " + product.getProductName());
        } else {
            System.out.println(this.name + " не может позволить себе " + product.getProductName());
        }
    }

}
