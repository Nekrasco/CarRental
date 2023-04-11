package ru.sber.homeproject.CarRental.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "drivers_licenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "drivers_license_seq", allocationSize = 1)
public class DriversLicense extends GenericModel{

    @Column(name = "category", nullable = false)
    @Enumerated()
    private Category category;

    @Column(name = "license_issue_date", nullable = false)
    private String licenseIssueDate;

    @Column(name = "series_license", nullable = false)
    private int seriesLicense;

    @Column(name = "number_license", nullable = false)
    private int numberLicense;

    @OneToOne(mappedBy = "driversLicense")
    private User user;
}
