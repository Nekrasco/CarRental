package ru.sber.homeproject.CarRental.carrental.mapper;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;
import ru.sber.homeproject.CarRental.carrental.dto.OrderDTO;
import ru.sber.homeproject.CarRental.carrental.model.Order;
import ru.sber.homeproject.CarRental.carrental.repository.CarRepository;
import ru.sber.homeproject.CarRental.carrental.repository.UserRepository;
import ru.sber.homeproject.CarRental.carrental.service.CarService;
import ru.sber.homeproject.CarRental.carrental.service.UserService;



@Component
public class OrderMapper extends GenericMapper<Order, OrderDTO> {


    private final CarRepository carRepository;
    private final UserRepository userRepository;

    private final CarService carService;
    private final UserService userService;

    protected OrderMapper(ModelMapper modelMapper,
                          CarRepository carRepository,
                          UserRepository userRepository,
                          CarService carService,
                          UserService userService) {
        super(modelMapper, Order.class, OrderDTO.class);
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.carService = carService;
        this.userService = userService;


    }

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Order.class, OrderDTO.class)
                .addMappings(m -> m.skip(OrderDTO::setCarId)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(OrderDTO::setUserId)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(OrderDTO::setCarDTO)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(OrderDTO::setUserDTO)).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(OrderDTO.class, Order.class)
                .addMappings(m -> m.skip(Order::setCar)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Order::setUser)).setPostConverter(toEntityConverter());

    }

    @Override
    protected void mapSpecificFields(OrderDTO source, Order destination) {
        destination.setCar(carRepository.findById(source.getCarId()).orElseThrow(() -> new NotFoundException("Авто не найден")));
        destination.setUser(userRepository.findById(source.getUserId()).orElseThrow(() -> new NotFoundException("Пользователь не найден")));

    }

    @Override
    protected void mapSpecificFields(Order source, OrderDTO destination) {
        destination.setCarId(source.getCar().getId());
        destination.setUserId(source.getUser().getId());
        destination.setCarDTO(carService.getOne(source.getCar().getId()));
        destination.setUserDTO(userService.getOne(source.getUser().getId()));

    }
}

