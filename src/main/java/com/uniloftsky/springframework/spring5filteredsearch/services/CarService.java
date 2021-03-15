package com.uniloftsky.springframework.spring5filteredsearch.services;

import com.uniloftsky.springframework.spring5filteredsearch.api.model.CarDTO;
import com.uniloftsky.springframework.spring5filteredsearch.filter.CarPage;
import com.uniloftsky.springframework.spring5filteredsearch.filter.CarSearchCriteria;
import org.springframework.data.domain.Page;

public interface CarService {

    Page<CarDTO> getFilteredCars(CarPage carPage, CarSearchCriteria carSearchCriteria);

}
