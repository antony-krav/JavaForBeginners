package ru.JavaForBeginners.attestation01;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        Product bread = new Product("Хлеб", 40);
//        Person Mike = new Person("Павел Андреевич", 10000);
//        Mike.buy(bread);
        ArrayList<Person> persons = new ArrayList<Person>();
        ArrayList<Product> products = new ArrayList<Product>();
        System.out.println("Добро пожаловать в систему.");

        while (true) {
            System.out.println("""
                    1\t- зарегистрировать покупателя
                    2\t- зарегистрировать товар
                    3\t- совершить продажу
                    END\t - выход""");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Введите имя и отчество покупателя:");
                    String personName = scanner.nextLine();
                    System.out.println("Введите сумму денег покупателя:");
                    int personMoney = scanner.nextInt();
                    persons.add(new Person(personName, personMoney));
                    System.out.println("Покупатель " + personName + " успешно зарегистрирован.\n");

                    break;
                case "2":
                    System.out.println("Введите название продукта:");
                    String productName = scanner.nextLine();
                    System.out.println("Введите стоимость продукта:");
                    int price = scanner.nextInt();
                    products.add(new Product(productName, price));
                    System.out.println("Продукт " + productName + " успешно зарегистрирован.\n");

                    break;
                case "3":
                    int indexPerson = -1;
                    int indexProduct = -1;
                    System.out.println("Выберите покупателя:");
                    for (int i = 0; i < persons.size(); i++) {
                        System.out.println(i + "\t- " + persons.get(i).getName());
                    }
                    indexPerson = scanner.nextInt();
                    System.out.println("Выберите продукт:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(i + "\t- " + products.get(i).getProductName());
                    }
                    indexProduct = scanner.nextInt();
                    persons.get(indexPerson).buy(products.get(indexProduct));
                    break;
                case "END":
                    break;
                default:
                    System.err.println("Неверный ввод. Повторите попытку");
            }
            if (input.equals("END")) {
                break;
            }
        }
    }
}
