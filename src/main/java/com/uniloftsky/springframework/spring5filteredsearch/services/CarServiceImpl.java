package com.uniloftsky.springframework.spring5filteredsearch.services;

import com.uniloftsky.springframework.spring5filteredsearch.api.mapper.CarMapper;
import com.uniloftsky.springframework.spring5filteredsearch.api.model.CarDTO;
import com.uniloftsky.springframework.spring5filteredsearch.filter.CarCriteriaRepository;
import com.uniloftsky.springframework.spring5filteredsearch.filter.CarPage;
import com.uniloftsky.springframework.spring5filteredsearch.filter.CarSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarCriteriaRepository carCriteriaRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarCriteriaRepository carCriteriaRepository, CarMapper carMapper) {
        this.carCriteriaRepository = carCriteriaRepository;
        this.carMapper = carMapper;
    }

    @Override
    public Page<CarDTO> getFilteredCars(CarPage carPage, CarSearchCriteria carSearchCriteria) {
        List<CarDTO> carDTOList = new ArrayList<>();
        carCriteriaRepository.findAllWithFilters(carPage, carSearchCriteria).forEach(car -> carDTOList.add(carMapper.carToCarDTO(car)));
        return new PageImpl<>(carDTOList);
    }
}
