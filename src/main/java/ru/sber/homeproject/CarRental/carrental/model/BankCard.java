package ru.sber.homeproject.CarRental.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bank_cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "bank_card_seq", allocationSize = 1)
public class BankCard extends GenericModel {

    @Column(name = "number_card", nullable = false)
    private String numberCard;

    @Column(name = "expiration_date", nullable = false)
    private String expirationDate;

    @Column(name = "code", nullable = false)
    private int code;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_BANK_CARDS_USER"))
    private User user;
}
