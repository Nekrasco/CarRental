package ru.sber.homeproject.CarRental.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "passport_seq", allocationSize = 1)
public class Passport extends GenericModel{

    @Column(name = "series_passport", nullable = false)
    private int seriesPassport;

    @Column(name = "number_passport", nullable = false)
    private int numberPassport;

    @Column(name = "date_is_issue", nullable = false)
    private String dateIsIssue;

    @Column(name = "issued_by", nullable = false)
    private String issuedBy;

    @OneToOne(mappedBy = "passport")
    private User user;




}
