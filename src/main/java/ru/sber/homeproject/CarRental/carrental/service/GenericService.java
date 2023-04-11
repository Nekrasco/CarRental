package ru.sber.homeproject.CarRental.carrental.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.sber.homeproject.CarRental.carrental.dto.GenericDTO;
import ru.sber.homeproject.CarRental.carrental.mapper.GenericMapper;
import ru.sber.homeproject.CarRental.carrental.model.GenericModel;
import ru.sber.homeproject.CarRental.carrental.repository.GenericRepository;

import java.util.List;

/**
 * Абстрактный сервис который хранит в себе реализацию CRUD операций по умолчанию
 * Если реализация отличная от того, что представлено в этом классе,
 * то она переопределяется в сервисе для конкретной сущности
 *
 * @param <T> - сущность с которой мы работаем
 * @param <N> - DTO, которую мы будем отдавать/принимать дальше
 */

@Service
public abstract class GenericService<T extends GenericModel, N extends GenericDTO> {

    protected final GenericRepository<T> genericRepository;

    protected final GenericMapper<T, N> genericMapper;

    protected GenericService(GenericRepository<T> genericRepository, GenericMapper<T, N> genericMapper) {
        this.genericRepository = genericRepository;
        this.genericMapper = genericMapper;
    }

    public List<N> listAll() {
        return genericMapper.toDTOs(genericRepository.findAll());
    }

    public N getOne(final Long id) {
        return genericMapper.toDTO(genericRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Данных по заданному id " + id + " не найдены")));
    }

    public N create(N newObject) {
        return genericMapper.toDTO(genericRepository.save(genericMapper.toEntity(newObject)));

    }

    public N update(N updateObject) {
        return genericMapper.toDTO(genericRepository.save(genericMapper.toEntity(updateObject)));
    }

    public void delete(Long id){
        genericRepository.deleteById(id);
    }
}
