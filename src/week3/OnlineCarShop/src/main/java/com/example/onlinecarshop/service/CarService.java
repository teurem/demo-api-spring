package com.example.onlinecarshop.service;

import com.example.onlinecarshop.entity.CarEntity;

import java.util.List;

public interface CarService {
    List<CarEntity> getAllCars();
    CarEntity getCarById(Long carId);

    void saveCar(CarEntity car);
    void updateCar(CarEntity car, Long carId);
    void deleteCar(Long carId);

}
