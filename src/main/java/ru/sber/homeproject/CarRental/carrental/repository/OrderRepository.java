package ru.sber.homeproject.CarRental.carrental.repository;

import org.springframework.stereotype.Repository;
import ru.sber.homeproject.CarRental.carrental.model.Order;

@Repository
public interface OrderRepository
        extends GenericRepository<Order> {
}
