/*  Lesson 10. Homework.
    Task 3:
    Задана строка, состоящая из букв английского алфавита, разделенных одним пробелом. Необходимо каждую
    последовательность символов упорядочить по возрастанию и вывести слова в нижнем регистре.
    Входные данные: в единственной строке последовательность символов представляющее два слова.
    Выходные данные: упорядоченные по возрастанию буквы в нижнем регистре.
 */

package ru.JavaForBeginners.Lesson_10;

import java.util.Arrays;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] firstWord = input.substring(0, input.indexOf(' ')).toLowerCase().toCharArray();
        char[] secondWord = input.substring(input.indexOf(' ') + 1).toLowerCase().toCharArray();

        Arrays.sort(firstWord);
        Arrays.sort(secondWord);

        String result = new String(firstWord) + " " + new String(secondWord);

        System.out.println(result);

    }
}
