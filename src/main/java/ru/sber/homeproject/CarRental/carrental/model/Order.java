package ru.sber.homeproject.CarRental.carrental.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "order_seq", allocationSize = 1)
public class Order extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDERS_USERS"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDERS_CARS"))
    private Car car;

    @Column(name = "rent_date", nullable = false)
    private LocalDate rentDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "rental_price", nullable = false)
    private double rentalPrice;


}
