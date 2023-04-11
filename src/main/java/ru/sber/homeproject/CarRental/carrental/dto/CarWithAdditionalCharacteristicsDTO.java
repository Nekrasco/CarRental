package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarWithAdditionalCharacteristicsDTO extends CarDTO {

    private Set<AdditionalCharacteristicsDTO> additionalCharacteristics;
}
