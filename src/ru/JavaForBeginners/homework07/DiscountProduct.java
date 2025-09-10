package ru.JavaForBeginners.homework07;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {
    private double discount;
    private LocalDate expiryDate;

    public DiscountProduct(String productName, double price, double discount, LocalDate expiryDate) {
        super(productName, price);
        setDiscount(discount);
        setExpiryDate(expiryDate);
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "productName='" + super.getProductName() + '\'' +
                ", price=" + super.getPrice() +
                ", discount=" + discount +
                ", expiryDate=" + expiryDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Double.compare(discount, that.discount) == 0 && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, expiryDate);
    }

    @Override
    public double getPrice() {
        if (expiryDate != null && LocalDate.now().isBefore(expiryDate)) {
            return super.getPrice() * (1.0 - discount);
        }
        return super.getPrice();
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setDiscount(double discount) {
        if (discount <= 0 || discount >= 100) {
            throw new IllegalArgumentException("Скидка должна быть больше 0 и меньше 100");
        }
        this.discount = discount / 100;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        if (expiryDate == null) {
            throw new IllegalArgumentException("Должен быть указан срок действия скидки");
        }
        this.expiryDate = expiryDate;
    }
}
