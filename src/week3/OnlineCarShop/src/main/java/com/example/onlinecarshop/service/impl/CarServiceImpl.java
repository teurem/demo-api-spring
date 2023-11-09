package com.example.onlinecarshop.service.impl;

import com.example.onlinecarshop.dto.CarDTO;
import com.example.onlinecarshop.entity.CarEntity;
import com.example.onlinecarshop.repository.CarRepository;
import com.example.onlinecarshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    private CarDTO convertingEntityToDto(CarEntity car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setCost(car.getCost());
        carDTO.setYear(car.getYear());
        carDTO.setModel(car.getModel());
        carDTO.setDescription(car.getDescription());
        return carDTO;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(this::convertingEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(Long carid) {
        return carRepository.findById(carid)
                .map(this::convertingEntityToDto)
                .orElseThrow(() -> new RuntimeException("car not found"));
    }

//    @Override
//    public CarEntity getCarById(Long carId) {
//        Optional<CarEntity> carOpt = carRepository.findById(carId);
//        if (carOpt.isPresent())
//            return carOpt.get();
//        else
//            throw new RuntimeException("car not found");
//    }

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
