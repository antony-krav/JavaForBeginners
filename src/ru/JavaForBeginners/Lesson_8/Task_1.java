/*  Lesson 8. Homework.
    Task 1:
    Составить программу вывода на экран в одну строку сообщения «Привет, имя_пользователя», где «имя_пользователя» - это
    введёное в консоль имя, для выполнения данного задания нужно использовать класс Scanner.
 */

package ru.JavaForBeginners.Lesson_8;

import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Привет, " + name);

        scanner.close();
    }
}
