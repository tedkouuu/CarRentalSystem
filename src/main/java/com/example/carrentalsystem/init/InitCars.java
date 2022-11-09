package com.example.carrentalsystem.init;

import com.example.carrentalsystem.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitCars implements CommandLineRunner {

    private final CarService carService;

    public InitCars(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.carService.initializeCars();
    }
}

