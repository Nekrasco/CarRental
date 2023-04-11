package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PassportDTO {

    private Integer seriesPassport;

    private Integer numberPassport;

    private String dateIsIssue;

    private String issuedBy;

    private Long userId;

}
