package ru.sber.homeproject.CarRental.carrental.mapper;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sber.homeproject.CarRental.carrental.dto.AdditionalCharacteristicsDTO;
import ru.sber.homeproject.CarRental.carrental.model.AdditionalCharacteristics;
import ru.sber.homeproject.CarRental.carrental.model.GenericModel;
import ru.sber.homeproject.CarRental.carrental.repository.CarRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
public class AdditionalCharacteristicsMapper
        extends GenericMapper<AdditionalCharacteristics, AdditionalCharacteristicsDTO> {

    private final CarRepository carRepository;

    protected AdditionalCharacteristicsMapper(ModelMapper modelMapper, CarRepository carRepository) {
        super(modelMapper, AdditionalCharacteristics.class, AdditionalCharacteristicsDTO.class);
        this.carRepository = carRepository;

    }


    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(AdditionalCharacteristics.class, AdditionalCharacteristicsDTO.class)
                .addMappings(m -> m.skip(AdditionalCharacteristicsDTO::setCarId)).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(AdditionalCharacteristicsDTO.class, AdditionalCharacteristics.class)
                .addMappings(m -> m.skip(AdditionalCharacteristics::setCars)).setPostConverter(toEntityConverter());

    }

    @Override
    protected void mapSpecificFields(AdditionalCharacteristicsDTO source, AdditionalCharacteristics destination) {
        if (!Objects.isNull(source.getCarId())) {
            destination.setCars(new HashSet<>(carRepository
                    .findAllById(source.getCarId())));
        } else {
            destination.setCars(Collections.emptySet());
        }
    }


    @Override
    protected void mapSpecificFields(AdditionalCharacteristics source, AdditionalCharacteristicsDTO destination) {
        destination.setCarId(Objects.isNull(source) ||
                Objects.isNull(source.getCars()) ? null
                : source.getCars()
                .stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet()));
    }
}


