package ru.sber.homeproject.CarRental.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "additional_characteristics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "additional_characteristics_seq", allocationSize = 1)
public class AdditionalCharacteristics
        extends GenericModel {

    @Column(name = "button", nullable = false)
    private String button;

    @Column(name = "air_conditioner", nullable = false)
    private String airConditioner;

    @Column(name = "climate_control", nullable = false)
    private String climateControl;

    @Column(name = "heated_front_seats", nullable = false)
    private String heatedFrontSeats;

    @Column(name = "heated_steering_wheel", nullable = false)
    private String heatedSteeringWheel;

    @Column(name = "drive_wheels", nullable = false)
    private String driveWheels;

    @Column(name = "audio_system", nullable = false)
    private String audioSystem;

    @Column(name = "navigation_system", nullable = false)
    private String navigationSystem;

    @Column(name = "cruise_control", nullable = false)
    private String cruiseControl;

    @Column(name = "airbag", nullable = false)
    private int airbag;

    @Column(name = "parktronic", nullable = false)
    private String parktronic;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "cars_additional_characteristics",
            joinColumns = @JoinColumn(name = "additional_characteristics_id"), foreignKey = @ForeignKey(name = "FK_ADDITIONAL_CHARACTERISTICS_CAR"),
            inverseJoinColumns = @JoinColumn(name = "car_id"),
            inverseForeignKey = @ForeignKey(name = "FK_CAR_ADDITIONAL_CHARACTERISTICS"))
    private Set<Car> cars;

}
