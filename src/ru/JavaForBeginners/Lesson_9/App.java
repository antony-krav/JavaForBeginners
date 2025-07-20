/*  Lesson 9. Homework.
    Реализовать класс Телевизор. У класса есть поля, свойства и методы. Проверить работу в классе App, методе main.
    Ожидаемый результат:
    1. Создан класс Телевизор;
    2. У класса есть поля, свойства и методы. Поля желательно сделать private. Задать новые значения полям класса можно
    через конструктор.
    4. Создан класс App с методом main.
    5. В методе main класса App создано несколько экземпляров класса Телевизор.
    6. Дополнительно. Задавать параметры класса Телевизор с клавиатуры или случайным числом.
 */

package ru.JavaForBeginners.Lesson_9;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Tv tvSamsung = new Tv("Samsung", "QE98QN90FAUXRU", 98);
        tvSamsung.turnOn();
        tvSamsung.setChannelNumber(12);
        tvSamsung.increaseVolume();
        tvSamsung.turnOff();
        tvSamsung.previousChannel(); // shouldn't work

        Tv tvSony = new Tv("Sony", "K-77XR80", 77, false, 1, 20);
        tvSony.turnOff(); // shouldn't work
        tvSony.turnOn(25);
        tvSony.previousChannel();
        tvSony.setVolume(100);
        tvSony.turnOff();
        tvSony.turnOff(); // shouldn't work

        System.out.println("Which channel do you want to watch?");

        Scanner scanner = new Scanner(System.in);
        int channelNumber = scanner.nextInt();
        tvSony.turnOn(channelNumber);

        scanner.close();
    }
}
