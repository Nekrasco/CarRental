package ru.sber.homeproject.CarRental.carrental.MVCcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sber.homeproject.CarRental.carrental.dto.*;
import ru.sber.homeproject.CarRental.carrental.service.AdditionalCharacteristicsService;
import ru.sber.homeproject.CarRental.carrental.service.CarService;

import java.util.List;

@Controller
@RequestMapping("cars")
public class MVCCarController {

    private final CarService carService;

    public MVCCarController(CarService carService, AdditionalCharacteristicsService additionalCharacteristicsService) {
        this.carService = carService;

    }


    @GetMapping("")
    public String getAll(Model model) {
        List<CarWithAdditionalCharacteristicsDTO> carDTOList = carService.getAllCarsWithAdditionalCharacteristics();
        model.addAttribute("cars", carDTOList);
        return "cars/viewAllCars";
    }


    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id,
                         Model model) {
        model.addAttribute("cars", carService.getCarWithAdd(id));
        return "cars/viewAdditionalCharacteristics";
    }

    @GetMapping("/add")
    public String create() {
        return "cars/addCars";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("carForm") CarDTO carDTO) {
        carService.create(carDTO);
        return "redirect:/cars";

    }
}


