package ru.sber.homeproject.CarRental.carrental.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDTO extends GenericDTO{
    private Long id;
    private String title;
    private String description;

}
