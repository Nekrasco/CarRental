package ru.sber.homeproject.CarRental.carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.sber.homeproject.CarRental.carrental.model.GenericModel;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel>
        extends JpaRepository<T,Long> {

}
