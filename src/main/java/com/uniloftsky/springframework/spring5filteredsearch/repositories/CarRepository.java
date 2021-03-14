package com.uniloftsky.springframework.spring5filteredsearch.repositories;

import com.uniloftsky.springframework.spring5filteredsearch.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
