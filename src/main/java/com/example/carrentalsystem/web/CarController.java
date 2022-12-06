package com.example.carrentalsystem.web;

import com.example.carrentalsystem.models.Car;
import com.example.carrentalsystem.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
Note: Front-End is need so the information can come to the controller
 */

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/car/add")
    public String addCar(Car car) {

        this.carService.addCar(car);

        return "redirect:/";
    }

    @PostMapping("/car/edit")
    public String editCar(Car carToEdit) {

        this.carService.editCar(carToEdit);

        return "redirect:/";
    }

    @GetMapping("/cars/get")
    public String getAllCars(Model model) {

        List<Car> allCars = this.carService.getAllCars();

        model.addAttribute("cars", allCars);

        return "cars-all";

    }

    @GetMapping("/car/get/available")
    public String geCarAvailableOrNot(Car car) {
        boolean isAvailable = this.carService.findIfCarIsAvailable(car);

        if (isAvailable) {
            car.setAvailable(false);
        }

        return "home";

    }

    @GetMapping("/car/get/availability")
    public String getCarAvailability(Car car, Model model) {

        boolean isAvailable = this.carService.findIfCarIsAvailable(car);

        model.addAttribute("carAvailability", isAvailable);

        return "home";

    }
}
