package ru.JavaForBeginners.attestation01;

public class Product {
    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
}
