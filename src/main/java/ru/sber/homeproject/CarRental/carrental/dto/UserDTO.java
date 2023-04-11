package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends GenericDTO {

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phone;

    private String birthDate;

    private Long passportId;

    private PassportDTO passportDTO;

    private Long driversLicenseId;

    private DriversLicenseDTO driversLicenseDTO;

    private Set<Long> bankCardIds;

    private Set<Long> ordersIds;

    private RoleDTO role;
}
