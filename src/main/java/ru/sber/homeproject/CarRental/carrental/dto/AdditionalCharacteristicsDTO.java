package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AdditionalCharacteristicsDTO extends GenericDTO {

    private String button;

    private String airConditioner;

    private String climateControl;

    private String heatedFrontSeats;

    private String heatedSteeringWheel;

    private String driveWheels;

    private String audioSystem;

    private String navigationSystem;

    private String cruiseControl;

    private Integer airbag;

    private String parktronic;

    private Set<Long> carId;
}
