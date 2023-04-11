package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO extends GenericDTO {

    private String name;

    private String color;

    private String body;

    private Integer numberOfSeats;

    private String transmission;

    private Double engineCapacity;

    private Integer power;

    private Double pricePerDay;

    private String registrationNumber;

    private Set<Long> additionalCharacteristicsId;

    private Set<Long> ordersIds;

//
//    public CarDTO(Car car) {
//        CarDTO carDTO = new CarDTO();
//        //из entity делаем DTO
//        carDTO.setName(car.getName());
//        carDTO.setColor(car.getColor());
//        carDTO.setBody(car.getBody());
//        carDTO.setId(car.getId());
//        carDTO.setNumberOfSeats(car.getNumberOfSeats());
//        carDTO.setTransmission(car.getTransmission());
//        carDTO.setEngineCapacity(car.getEngineCapacity());
//        carDTO.setPower(car.getPower());
//        carDTO.setPricePerDay(car.getPricePerDay());
//        carDTO.setRegistrationNumber(car.getRegistrationNumber());
//        Set<AdditionalCharacteristics> additionalCharacteristics = car.getAdditionalCharacteristics();
//        Set<Long> additionalCharacteristicsId = new HashSet<>();
//        Set<Order> orders = car.getOrders();
//        Set<Long> ordersIds = new HashSet<>();
//        carDTO.setAdditionalCharacteristicsId(additionalCharacteristicsId);
//        carDTO.setOrdersIds(ordersIds);
//    }
}

