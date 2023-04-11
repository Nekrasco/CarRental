package ru.sber.homeproject.CarRental.carrental.mapper;


import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sber.homeproject.CarRental.carrental.dto.CarDTO;
import ru.sber.homeproject.CarRental.carrental.model.Car;
import ru.sber.homeproject.CarRental.carrental.model.GenericModel;
import ru.sber.homeproject.CarRental.carrental.repository.AdditionalCharacteristicsRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
public class CarMapper extends GenericMapper<Car, CarDTO> {

    private final AdditionalCharacteristicsRepository additionalCharacteristicsOfTheCarRepository;


    protected CarMapper(ModelMapper modelMapper, AdditionalCharacteristicsRepository additionalCharacteristicsOfTheCarRepository) {
        super(modelMapper, Car.class, CarDTO.class);
        this.additionalCharacteristicsOfTheCarRepository = additionalCharacteristicsOfTheCarRepository;

    }

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Car.class, CarDTO.class)
                .addMappings(m -> m.skip(CarDTO::setAdditionalCharacteristicsId)).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(CarDTO.class, Car.class)
                .addMappings(m -> m.skip(Car::setAdditionalCharacteristics)).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(CarDTO source, Car destination) {
        if (!Objects.isNull(source.getAdditionalCharacteristicsId())) {
            destination.setAdditionalCharacteristics(new HashSet<>(additionalCharacteristicsOfTheCarRepository
                    .findAllById(source.getAdditionalCharacteristicsId())));
        } else {
            destination.setAdditionalCharacteristics(Collections.emptySet());
        }
    }


    @Override
    protected void mapSpecificFields(Car source, CarDTO destination) {
        destination.setAdditionalCharacteristicsId(Objects.isNull(source) ||
                Objects.isNull(source.getAdditionalCharacteristics()) ? null
                : source.getAdditionalCharacteristics()
                .stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet()));

    }
}


