package ru.sber.homeproject.CarRental.carrental.repository;

import org.springframework.stereotype.Repository;
import ru.sber.homeproject.CarRental.carrental.model.User;

@Repository
public interface UserRepository
        extends GenericRepository<User> {

    //    Запрос в БД по логину
    User findUserByLogin(String login);

    //  Запрос в БД по емаил
    User findUserByEmail(String email);

}
