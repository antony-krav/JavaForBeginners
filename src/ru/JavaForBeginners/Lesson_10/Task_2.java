/*  Lesson 10. Homework.
    Task 2:
    Задана последовательность, состоящая только из символов ‘>’, ‘<’ и ‘-‘. Требуется найти количество стрел, которые
    спрятаны в этой последовательности. Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.
    Входные данные: в первой строке входного потока записана строка, состоящая из символов ‘>’, ‘<’ и ‘-‘ (без
    пробелов). Строка может содержать до 106 символов.
    Выходные данные: в единственную строку выходного потока нужно вывести искомое количество стрелок.
*/

package ru.JavaForBeginners.Lesson_10;

import java.util.Scanner;

import static java.lang.Math.min;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sequence = scanner.nextLine();

        int counter = 0;
        for (int i = 0; i < sequence.length(); ) {
            int rightArrowFirstIndex = sequence.indexOf(">>-->", i);
            int leftArrowFirstIndex = sequence.indexOf("<--<<", i);

            if (rightArrowFirstIndex >= 0 || leftArrowFirstIndex >= 0) {
                counter++;
                if (rightArrowFirstIndex == -1) {
                    rightArrowFirstIndex = 999;
                }
                if (leftArrowFirstIndex == -1) {
                    leftArrowFirstIndex = 999;
                }
                i = min(rightArrowFirstIndex, leftArrowFirstIndex) + 5;
            } else {
                break;
            }
        }
        System.out.println(counter);
    }
}