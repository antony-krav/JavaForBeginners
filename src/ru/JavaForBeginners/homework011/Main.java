package ru.JavaForBeginners.homework011;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("a123me", "Mercedes", "White", 0, 8300000),
                new Car("b873of", "Volga", "Black", 0, 673000),
                new Car("w487mn", "Lexus", "Grey", 76000, 900000),
                new Car("p987hj", "Volga", "Red", 610, 704340),
                new Car("c987ss", "Toyota", "White", 254000, 761000),
                new Car("o983op", "Toyota", "Black", 698000, 740000),
                new Car("p146op", "BMW", "White", 271000, 850000),
                new Car("u893ii", "Toyota", "Purple", 210900, 440000),
                new Car("l097df", "Toyota", "Black", 108000, 780000),
                new Car("y876wd", "Toyota", "Black", 160000, 1000000)
        ));

        String colorToFind = "Black";
        long mileageToFind = 0L;
        long priceFrom = 700_000L;
        long priceTo = 800_000L;
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        System.out.println("Автомобили в базе:");
        System.out.printf("%-8s %-10s %-8s %-8s %sn", "Number","Model", "Color", "Mileage", "Cost");
        cars.forEach(System.out::println);
        System.out.println();

        String numberByColorToFind = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.joining(" "));
        System.out.println("Номера автомобилей по цвету или пробегу: " + numberByColorToFind);

        long distinctModels = cars.stream()
                .filter(car -> car.getPrice() >= priceFrom && car.getPrice() <= priceTo)
                .map(Car::getNumber) // по условия .map(Car::getModel), но совпадают выходные данные
                .distinct()
                .count();
        System.out.println("Уникальные автомобили: " + distinctModels + " шт.");

        String color = cars.stream()
                .min(Comparator.comparingLong(Car::getPrice))
                .map(Car::getColor)
                .orElse(null);
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + color);

        double avgPrice1 = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(modelToFind1))
                .mapToLong(Car::getPrice)
                .average()
                .orElse(.0);
        System.out.println("Средняя стоимость модели " + modelToFind1 + ": " + avgPrice1);

        double avgPrice2 = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(modelToFind2))
                .mapToLong(Car::getPrice)
                .average()
                .orElse(.0);
        System.out.println("Средняя стоимость модели " + modelToFind2 + ": " + avgPrice2);
    }
}