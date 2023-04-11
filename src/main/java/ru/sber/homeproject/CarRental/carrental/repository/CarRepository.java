package ru.sber.homeproject.CarRental.carrental.repository;

import org.springframework.stereotype.Repository;
import ru.sber.homeproject.CarRental.carrental.model.Car;

@Repository
public interface CarRepository
        extends GenericRepository<Car> {
}
