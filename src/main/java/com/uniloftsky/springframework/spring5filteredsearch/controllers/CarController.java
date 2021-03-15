package com.uniloftsky.springframework.spring5filteredsearch.controllers;

import com.uniloftsky.springframework.spring5filteredsearch.api.model.CarDTO;
import com.uniloftsky.springframework.spring5filteredsearch.filter.CarPage;
import com.uniloftsky.springframework.spring5filteredsearch.filter.CarSearchCriteria;
import com.uniloftsky.springframework.spring5filteredsearch.services.CarService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Page<CarDTO>> getCars(CarPage carPage, CarSearchCriteria carSearchCriteria) {
        return new ResponseEntity<>(carService.getFilteredCars(carPage, carSearchCriteria), HttpStatus.OK);
    }

}
