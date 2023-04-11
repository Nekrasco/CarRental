package ru.sber.homeproject.CarRental.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "car_seq", allocationSize = 1)
public class Car extends GenericModel {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @Column(name = "transmission", nullable = false)
    private String transmission;

    @Column(name = "engine_capacity", nullable = false)
    private Double engineCapacity;

    @Column(name = "power", nullable = false)
    private Integer power;

    @Column(name = "price_per_day", nullable = false)
    private Double pricePerDay;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;


    @ManyToMany @JoinTable(name = "cars_additional_characteristics",
    joinColumns = @JoinColumn(name = "car_id"), foreignKey = @ForeignKey(name = "FK_CAR_ADDITIONAL_CHARACTERISTICS"),
            inverseJoinColumns = @JoinColumn(name = "additional_characteristics_id"),
            inverseForeignKey = @ForeignKey(name = "FK_ADDITIONAL_CHARACTERISTICS_CAR"))
    private Set<AdditionalCharacteristics> additionalCharacteristics;


    @OneToMany(mappedBy = "car")
    private Set<Order> orders;

}
