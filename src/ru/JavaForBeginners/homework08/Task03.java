/*  Lesson 23. Homework 8.
    Task 1:
    Реализовать класс PowerfulSet, в котором должны быть следующие методы:
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) – возвращает пересечение двух наборов.
    Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
    public <T> Set<T> union(Set<T> set1, Set<T> set2) – возвращает объединение двух наборов
    Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) – возвращает элементы первого набора без тех, которые
    находятся также и во втором наборе.
    Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}
 */

package ru.JavaForBeginners.homework08;

import java.util.HashSet;
import java.util.Set;

public class Task03 {
    public static class PowerfulSet {
        public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
            Set<T> result = new HashSet<>(set1);
            result.retainAll(set2);
            return result;
        }

        public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
            Set<T> result = new HashSet<>(set1);
            result.addAll(set2);
            return result;
        }

        public static <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
            Set<T> result = new HashSet<>(set1);
            result.removeAll(set2);
            return result;
        }
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(0, 1, 2, 4);

        System.out.println("Intersection:\t" + PowerfulSet.intersection(set1, set2));
        System.out.println("Union:\t" + PowerfulSet.union(set1, set2));
        System.out.println("RelativeComplement:\t" + PowerfulSet.relativeComplement(set1, set2));
    }
}
