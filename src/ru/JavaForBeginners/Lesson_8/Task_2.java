/*  Lesson 8. Homework.
    Task 2:
    Вася и Петя играют в игру “Камень, ножницы, бумага”. Каждый из них показывает свою фигуру камень-0, ножницы-1,
    бумага-2. Программа определяет, кто из них выиграл.
    Выбор каждого участника формируется случайным образом.
 */

package ru.JavaForBeginners.Lesson_8;

public class Task_2 {

    public static void main(String[] args) {

        int vasyaTurn = (int) (Math.random() * 3.0);
        int petyaTurn = (int) (Math.random() * 3.0);

        if (vasyaTurn == petyaTurn) {
            System.out.println("Ничья ¯\\_(ツ)_/¯");
        } else if (vasyaTurn == petyaTurn - 1 || (vasyaTurn == 2 && petyaTurn == 0)) {
            System.out.println("Победитель Вася");
        } else {
            System.out.println("Победитель Петя");
        }

    }
}
