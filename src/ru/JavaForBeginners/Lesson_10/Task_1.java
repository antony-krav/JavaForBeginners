/*  Lesson 10. Homework.
    Task 1:
    Для введенной с клавиатуры буквы английского алфавита нужно вывести слева стоящую букву на стандартной клавиатуре.
    При этом клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a», а слева от "а" буква "р", также соседними
    считаются буквы «l» и буква «z», а буква «m» с буквой «q».
    Входные данные: строка входного потока содержит один символ — маленькую букву английского алфавита.
    Выходные данные: следует вывести букву стоящую слева от заданной буквы, с учетом замкнутости клавиатуры.
 */

package ru.JavaForBeginners.Lesson_10;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        final String keyboardAlphabet = "qwertyuiopasdfghjklzxcvbnm";

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        int index = keyboardAlphabet.indexOf(input);

        if (index == 0) {
            index = keyboardAlphabet.length();
        }

        System.out.println(keyboardAlphabet.charAt(--index));
    }
}
