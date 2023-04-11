package ru.sber.homeproject.CarRental.carrental.mapper;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sber.homeproject.CarRental.carrental.dto.CarWithAdditionalCharacteristicsDTO;
import ru.sber.homeproject.CarRental.carrental.model.Car;
import ru.sber.homeproject.CarRental.carrental.model.GenericModel;
import ru.sber.homeproject.CarRental.carrental.repository.AdditionalCharacteristicsRepository;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CarWithAdditionalCharacteristicsMapper
        extends GenericMapper<Car, CarWithAdditionalCharacteristicsDTO> {

    private final AdditionalCharacteristicsRepository additionalCharacteristicsRepository;

    protected CarWithAdditionalCharacteristicsMapper(ModelMapper modelMapper,
                                                     AdditionalCharacteristicsRepository additionalCharacteristicsOfTheCarRepository) {
        super(modelMapper, Car.class, CarWithAdditionalCharacteristicsDTO.class);
        this.additionalCharacteristicsRepository = additionalCharacteristicsOfTheCarRepository;
    }

    @PostConstruct
    protected void setupMapper() {
        modelMapper.createTypeMap(Car.class, CarWithAdditionalCharacteristicsDTO.class)
                .addMappings(m -> m.skip(CarWithAdditionalCharacteristicsDTO::setAdditionalCharacteristicsId)).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(CarWithAdditionalCharacteristicsDTO.class, Car.class)
                .addMappings(m -> m.skip(Car::setAdditionalCharacteristics)).setPostConverter(toEntityConverter());
}

    @Override
    void mapSpecificFields(CarWithAdditionalCharacteristicsDTO source, Car destination) {
        destination.setAdditionalCharacteristics(new HashSet<>(additionalCharacteristicsRepository.
                findAllById(source.getAdditionalCharacteristicsId())));
    }

    @Override
    void mapSpecificFields(Car source, CarWithAdditionalCharacteristicsDTO destination) {
        destination.setAdditionalCharacteristicsId(Objects.isNull(source) || Objects.isNull(source.getId())
                ? null
                : source.getAdditionalCharacteristics()
                .stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet()));
    }
}
