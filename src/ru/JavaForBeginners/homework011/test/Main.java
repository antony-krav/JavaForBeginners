package ru.JavaForBeginners.homework011.test;

import ru.JavaForBeginners.homework011.model.Car;
import ru.JavaForBeginners.homework011.repository.CarsRepository;
import ru.JavaForBeginners.homework011.repository.CarsRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String path = "out\\production\\JavaForBeginners\\ru\\JavaForBeginners\\homework011\\data\\cars.txt";
        CarsRepository repo = new CarsRepositoryImpl(path);

        List<Car> cars = repo.readCars();

        String colorToFind = "Black";
        long mileageToFind = 0L;
        long priceFrom = 700_000L;
        long priceTo = 800_000L;
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        System.out.println("Автомобили в базе:");
        System.out.printf("%-8s %-10s %-8s %-8s %-8s", "Number", "Model", "Color", "Mileage", "Cost");
        System.out.println();
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