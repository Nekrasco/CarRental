package ru.sber.homeproject.CarRental.carrental.service;


import org.springframework.stereotype.Service;
import ru.sber.homeproject.CarRental.carrental.dto.OrderDTO;
import ru.sber.homeproject.CarRental.carrental.mapper.OrderMapper;
import ru.sber.homeproject.CarRental.carrental.model.Order;
import ru.sber.homeproject.CarRental.carrental.repository.OrderRepository;

@Service
public class OrderService extends GenericService<Order, OrderDTO>{

    protected OrderService(OrderRepository orderRepository, OrderMapper orderMapper){
        super(orderRepository,orderMapper);
    }
}
