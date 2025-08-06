package ru.JavaForBeginners.attestation01;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private double moneyAmount;
    private ArrayList<Product> products;

    Person(String name, double moneyAmount) {
        setName(name);
        setMoneyAmount(moneyAmount);
        this.products = new ArrayList<>();
    }

    Person(String name) {
        setName(name);
        this.moneyAmount = .0;
        this.products = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", moneyAmount=" + moneyAmount +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return moneyAmount == person.moneyAmount
                && Objects.equals(name, person.name)
                && Objects.equals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moneyAmount, products);
    }

    public String getName() {
        return name;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        if (name == null) {
            System.err.println("Имя не может быть пустым");
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if (name.length() < 3) {
            System.err.println("Имя не может быть короче 3 символов");
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        } else
            this.name = name;
    }

    public void setMoneyAmount(double moneyAmount) {
        if (moneyAmount < .0) {
            System.err.println("Деньги не могут быть отрицательными");
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.moneyAmount = moneyAmount;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void buy(Product product) {
        if (this.moneyAmount >= product.getPrice()) {
            this.moneyAmount -= product.getPrice();
            this.products.add(product);
            System.out.println(this.name + " купил " + product.getProductName());
        } else {
            System.err.println(this.name + " не может позволить себе " + product.getProductName());
        }
    }
}