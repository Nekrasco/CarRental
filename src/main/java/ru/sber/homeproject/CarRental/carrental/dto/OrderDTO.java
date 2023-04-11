package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class OrderDTO extends GenericDTO {


    private UserDTO userDTO;

    private CarDTO carDTO;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private Double rentalPrice;

    private Long userId;

    private Long carId;

}
