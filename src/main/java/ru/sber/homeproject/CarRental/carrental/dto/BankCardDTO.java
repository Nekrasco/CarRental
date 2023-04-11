package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BankCardDTO extends GenericDTO {

    private String numberCard;

    private String expirationDate;

    private Integer code;

    private Long userId;

}
