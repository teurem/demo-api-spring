package com.example.onlinecarshop.controller;

import com.example.onlinecarshop.entity.CarEntity;
import com.example.onlinecarshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarEntity> getAllCars() {
        List<CarEntity> cars = carService.getAllCars();
        System.out.println("cars: " +cars);
        return cars;
    }

    @GetMapping("/{carId}")
    public CarEntity getCarById(@PathVariable Long carId) {
        CarEntity car = carService.getCarById(carId);
        System.out.println("carId: " +carId+ "car: " +car);
        return car;
    }

    @PostMapping
    public String saveCar(@RequestBody CarEntity car) {
        carService.saveCar(car);
        return "car saved successfuly";
    }

    @PutMapping("/{carId}")
    public String updateCar(@RequestBody CarEntity car, @PathVariable Long carId) {
        carService.updateCar(car, carId);
        return "car update successfuly.";
    }

    @DeleteMapping("/{carId}")
    public String deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
        return "car deleted successfuly";
    }
}
