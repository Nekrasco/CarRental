package ru.sber.homeproject.CarRental.carrental.service;

import org.springframework.stereotype.Service;
import ru.sber.homeproject.CarRental.carrental.dto.*;

import ru.sber.homeproject.CarRental.carrental.mapper.CarMapper;
import ru.sber.homeproject.CarRental.carrental.mapper.CarWithAdditionalCharacteristicsMapper;
import ru.sber.homeproject.CarRental.carrental.model.Car;
import ru.sber.homeproject.CarRental.carrental.repository.CarRepository;

import java.util.List;


@Service
public class CarService extends GenericService<Car, CarDTO> {


    private final CarRepository carRepository;
    private final CarWithAdditionalCharacteristicsMapper carWithAdditionalCharacteristicsMapper;


    protected CarService(CarRepository carRepository,
                         CarMapper carMapper, CarWithAdditionalCharacteristicsMapper carWithAdditionalCharacteristicsMapper) {
        super(carRepository, carMapper);
        this.carRepository = carRepository;
        this.carWithAdditionalCharacteristicsMapper = carWithAdditionalCharacteristicsMapper;

    }

    public CarWithAdditionalCharacteristicsDTO getCarWithAdd(Long id) {
        return carWithAdditionalCharacteristicsMapper.toDTO(genericMapper.toEntity(super.getOne(id)));

    }

    public List<CarWithAdditionalCharacteristicsDTO> getAllCarsWithAdditionalCharacteristics() {
        return carWithAdditionalCharacteristicsMapper.toDTOs(carRepository.findAll());
    }

    }


