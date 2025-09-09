/*  Lesson 23. Homework 8.
    Task 1:
    Реализовать метод, который на вход принимает ArrayList, а возвращает набор уникальных элементов этого массива.
    Решить, используя коллекции
 */

package ru.JavaForBeginners.homework08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task01 {

    public static <T> Set<T> distinct(ArrayList<T> list) {
        return new HashSet<>(list);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>() {
            {
                add("a");
                add("z");
                add("z");
                add("a");
                add("k");
                add("a");
                add("k");
                add("a");
            }
        };
        Set<String> distinctList = distinct(list);
        System.out.println(distinctList);
    }
}
