package com.example.carrentalsystem.service;

import com.example.carrentalsystem.models.Car;
import com.example.carrentalsystem.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void initializeCars() {

        if (carRepository.count() != 0) {
            return;
        }

        Car ferrari = new Car("Ferrari", false, 3500);
        Car bugatti = new Car("Bugatti", false, 6000);
        Car lada = new Car("Lada", true, 200);
        Car chevrolet = new Car("Chevrolet", true, 1000);
        Car mustang = new Car("Mustang", true, 2000);

        List<Car> cars = List.of(ferrari, bugatti, lada, chevrolet, mustang);

        carRepository.saveAll(cars);
    }

    public void addCar(Car car) {

        Car car1 = new Car(car.getModel(), car.isAvailable(), car.getMonthlyRent());

        this.carRepository.save(car1);
    }

    public void editCar(Car carToEdit) {

        Optional<Car> carToChange = this.carRepository.findByModel(carToEdit.getModel());

        if (carToChange.isEmpty()) {
            throw new RuntimeException("This car does not exist");
        }

        Car carToSave = carToChange.get();

        carToSave.setModel(carToEdit.getModel());
        carToSave.setMonthlyRent(carToEdit.getMonthlyRent());
        carToSave.setAvailable(carToEdit.isAvailable());

        this.carRepository.save(carToSave);
    }


    public List<Car> getAllCars() {

        if (this.carRepository.count() == 0) {
            throw new RuntimeException("There are no cars in the database");
        }

        return this.carRepository.findAll();

    }


    public boolean findIfCarIsAvailable(Car car) {

        Optional<Car> carAv = this.carRepository.findByModel(car.getModel());

        Car carToCheck = carAv.get();

        if (carToCheck.isAvailable()) {
            return true;
        }

        return false;

    }
}

