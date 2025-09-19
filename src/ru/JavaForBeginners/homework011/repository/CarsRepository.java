package ru.JavaForBeginners.homework011.repository;

import ru.JavaForBeginners.homework011.model.Car;

import java.util.List;

public interface CarsRepository {
    List<Car> readCars();
    void writeCars(List<Car> cars);
}