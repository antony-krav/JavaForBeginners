/*  Lesson 23. Homework 8.
    Task 2:
    С консоли на вход подается две строки s и t. Необходимо вывести true, если одна строка является валидной анаграммой
    другой строки, и false – если это не так. Анаграмма – это слово, или фраза, образованная путем перестановки букв
    другого слова или фразы, обычно с использованием всех исходных букв ровно один раз.
    Для проверки:
      * Бейсбол – бобслей
      * Героин – регион
      * Клоака – околка
 */

package ru.JavaForBeginners.homework08;

import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static boolean isAnagram(String s, String t) {
        s = s.toLowerCase().replaceAll("\\s", "");
        t = t.toLowerCase().replaceAll("\\s", "");

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую строку:\t");
        String s = scanner.nextLine();

        System.out.println("Введите первую строку:\t");
        String t = scanner.nextLine();

        System.out.println(isAnagram(s, t));

        scanner.close();
    }
}

