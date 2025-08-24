package ru.JavaForBeginners.homework07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Введите через ';' список покупателей в формате: Имя = сумма покупки");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] personsArray = input.split(";");
        for (String person : personsArray) {
            String[] temp = person.split("=");
            String name = temp[0].trim();
            double money = Double.parseDouble(temp[1].trim());
            persons.add(new Person(name, money));
        }

        System.out.println("Введите через ';' список продуктов в формате: Название = цена");
        System.out.println("Для скидочных продуктов используйте формат: Название = цена = размер_скидки (0 - 100) = " +
                "срок_действия (ГГГГ-ММ-ДД)");
        input = scanner.nextLine();
        String[] productArray = input.split(";");
        for (String product : productArray) {
            String[] temp = product.split("=");
            if (temp.length == 2) {
                String name = temp[0].trim();
                double price = Double.parseDouble(temp[1].trim());
                products.add(new Product(name, price));
            } else if (temp.length == 4) {
                String name = temp[0].trim();
                double price = Double.parseDouble(temp[1].trim());
                double discount = Double.parseDouble(temp[2].trim());
                LocalDate expiryDate = LocalDate.parse(temp[3].trim());
                products.add(new DiscountProduct(name, price, discount, expiryDate));
            } else {
                System.err.println("Аттрибуты введены неверно");
            }
        }

        System.out.println("Введите покупку в формате: Имя_Покупателя - Название_Продукта. Для выхода введите END");
        while (true) {
            input = scanner.nextLine();
            if (input.equals("END")) break;

            String[] temp = input.split("-");
            String person = temp[0].trim();
            String product = temp[1].trim();

            Person curPerson = null;
            Product curProduct = null;

            for (Person p : persons) {
                if (p.getName().equals(person)) {
                    curPerson = p;
                    break;
                }
            }

            for (Product p : products) {
                if (p.getProductName().equals(product)) {
                    curProduct = p;
                    break;
                }
            }

            if (curPerson != null & curProduct != null) {
                curPerson.buy(curProduct);
            } else {
                System.err.println("Продукт или покупатель не найден. Повторите ввод");
            }
        }
        System.out.println();

        for (Person p : persons) {
            System.out.print(p.getName() + " - ");
            if (p.getProducts().isEmpty()) {
                System.out.println("Ничего не куплено");
            } else {
                for (int i = 0; i < p.getProducts().size(); i++) {
                    System.out.print(p.getProducts().get(i).getProductName());
                    if (i < p.getProducts().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}