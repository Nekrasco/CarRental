package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sber.homeproject.CarRental.carrental.model.Category;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DriversLicenseDTO extends GenericDTO {

    private Category category;

    private String licenseIssueDate;

    private Integer seriesLicense;

    private Integer numberLicense;

    private Long userId;

}
