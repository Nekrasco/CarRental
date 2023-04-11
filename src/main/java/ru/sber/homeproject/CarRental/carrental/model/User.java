package ru.sber.homeproject.CarRental.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(name = "uniqueEmail", columnNames = "email"),
                                            @UniqueConstraint(name = "uniqueLogin", columnNames = "login")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "user_seq", allocationSize = 1)
public class User extends GenericModel {

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "meddle_name", nullable = false)
    private String middleName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "passport_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_PASSPORT"))
    private Passport passport;

    @OneToOne
    @JoinColumn(name = "drivers_license_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_DRIVERS_LICENSE"))
    private DriversLicense driversLicense;

    @OneToMany(mappedBy = "user")
    private Set<BankCard> bankCards;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_ROLES"))
    private Role role;









}
