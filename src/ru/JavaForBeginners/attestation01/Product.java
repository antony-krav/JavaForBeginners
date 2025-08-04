package ru.JavaForBeginners.attestation01;

import java.util.Objects;

public class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        setProductName(productName);
        setPrice(price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        if(productName == null){
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой");
        }
        this.productName = productName;
    }

    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательным числом");
        }
        this.price = price;
    }
}
