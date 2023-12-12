package com.example.mongof1.Services;

import com.example.mongof1.Models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCarById(String id);
    Car saveCar(Car car);
    void deleteCar(String id);
}