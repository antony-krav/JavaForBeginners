package ru.JavaForBeginners.homework011.repository;

import ru.JavaForBeginners.homework011.model.Car;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CarsRepositoryImpl implements CarsRepository {
    private final Path filePath;

    public CarsRepositoryImpl(String filePathStr) {
        this.filePath = Paths.get(filePathStr);
    }


    @Override
    public List<Car> readCars() {
        List<Car> cars = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] parts = line.split(" ");
                try {
                    String number = parts[0].trim();
                    String model = parts[1].trim();
                    String color = parts[2].trim();
                    long mileage = Long.parseLong(parts[3].trim());
                    long price = Long.parseLong(parts[4].trim());
                    cars.add(new Car(number, model, color, mileage, price));
                } catch (NumberFormatException ex) {
                    System.err.println("Ошибка чтение на строке: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + filePath, e);
        }
        return cars;
    }

    @Override
    public void writeCars(List<Car> cars) {
        try {
            try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                for (Car car : cars) {
                    String line = String.join(" ",
                            car.getNumber(),
                            car.getModel(),
                            car.getColor(),
                            String.valueOf(car.getMileage()),
                            String.valueOf(car.getPrice()));
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл: " + filePath, e);
        }
    }
}