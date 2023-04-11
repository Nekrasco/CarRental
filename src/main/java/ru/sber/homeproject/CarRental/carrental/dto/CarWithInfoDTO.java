package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
public class CarWithInfoDTO extends UserDTO {
    private LocalDate rentDate;
    private LocalDate returnDate;
    private String lastName;
    private String firstName;
    private String middleName;
}


