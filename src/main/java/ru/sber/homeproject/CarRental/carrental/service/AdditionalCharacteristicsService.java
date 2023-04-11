package ru.sber.homeproject.CarRental.carrental.service;

import org.springframework.stereotype.Service;
import ru.sber.homeproject.CarRental.carrental.dto.AdditionalCharacteristicsDTO;
import ru.sber.homeproject.CarRental.carrental.mapper.AdditionalCharacteristicsMapper;
import ru.sber.homeproject.CarRental.carrental.mapper.CarWithAdditionalCharacteristicsMapper;
import ru.sber.homeproject.CarRental.carrental.model.AdditionalCharacteristics;
import ru.sber.homeproject.CarRental.carrental.repository.AdditionalCharacteristicsRepository;

@Service
public class AdditionalCharacteristicsService extends
        GenericService<AdditionalCharacteristics, AdditionalCharacteristicsDTO> {

    private CarWithAdditionalCharacteristicsMapper carWithAdditionalCharacteristicsMapper;

    protected AdditionalCharacteristicsService(AdditionalCharacteristicsRepository additionalCharacteristicsOfTheCaRepository,
                                               AdditionalCharacteristicsMapper additionalCharacteristicsOfTheCarMapper) {
        super(additionalCharacteristicsOfTheCaRepository, additionalCharacteristicsOfTheCarMapper);
    }


}
