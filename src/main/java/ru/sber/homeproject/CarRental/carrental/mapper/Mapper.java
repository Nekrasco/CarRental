package ru.sber.homeproject.CarRental.carrental.mapper;

import ru.sber.homeproject.CarRental.carrental.dto.GenericDTO;
import ru.sber.homeproject.CarRental.carrental.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDTO> {

    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntities(List<D> dtos);

    List<D> toDTOs(List<E> entities);
}
