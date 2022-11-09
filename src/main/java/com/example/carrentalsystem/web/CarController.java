package com.example.carrentalsystem.web;

import com.example.carrentalsystem.models.Car;
import com.example.carrentalsystem.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/car/add") // This is my idea how the adding should be done. I need front-end, so the data can come
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

        // Here I can attach the cars in the model, so I can visualise them in the front-end
        model.addAttribute("cars", allCars);

        return "cars-all";

    }

    @GetMapping("/car/get/available")
    public String geCarAvailableOrNot(Car car) { // In the front end, the user will search for the car and a message is going to pop up if the car is not free

        boolean isAvailable = this.carService.findIfCarIsAvailable(car);

        if (isAvailable) {
            car.setAvailable(false);
        }

        return "home";

    }

    @GetMapping("/car/get/availability")
    public String getCarAvailability(Car car, Model model) { // In the front end, the user will search for the car and a message is going to pop up if the car is not free

        boolean isAvailable = this.carService.findIfCarIsAvailable(car);

        model.addAttribute("carAvailability", isAvailable);
        /*
        I have checked for the car's availability, now I can show the information in the front-end
         */

        return "home";

    }
}
