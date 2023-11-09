package com.example.onlinecarshop.service.impl;

import com.example.onlinecarshop.entity.CarEntity;
import com.example.onlinecarshop.repository.CarRepository;
import com.example.onlinecarshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(Long carId) {
        Optional<CarEntity> carOpt = carRepository.findById(carId);
        if (carOpt.isPresent())
            return carOpt.get();
        else
            throw new RuntimeException("car not found");
    }

    @Override
    public void saveCar(CarEntity car) {
       CarEntity carDetail = carRepository.save(car);
        System.out.println("car saved in db with carId: " +carDetail.getId());
    }

    @Override
    public void updateCar(CarEntity car, Long carId) {
        Optional<CarEntity> carOpt = carRepository.findById(carId);
        if (carOpt.isPresent()) {
            CarEntity carDetail = carOpt.get();
            if (car.getBrand() != null || car.getBrand().isEmpty())
                carDetail.setBrand(car.getBrand());
            if (car.getModel() != null || car.getBrand().isEmpty())
                carDetail.setModel(car.getModel());
            if (car.getDescription() != null || car.getDescription().isEmpty())
                carDetail.setDescription(car.getDescription());
        }
    }

    @Override
    public void deleteCar(Long carId) {
        Optional<CarEntity> carOpt = carRepository.findById(carId);
        if (carOpt.isPresent())
            carRepository.deleteById(carId);
        else
            throw new RuntimeException("car not found");
    }
}
