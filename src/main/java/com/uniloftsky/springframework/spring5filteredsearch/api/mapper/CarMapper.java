package com.uniloftsky.springframework.spring5filteredsearch.api.mapper;

import com.uniloftsky.springframework.spring5filteredsearch.api.model.CarDTO;
import com.uniloftsky.springframework.spring5filteredsearch.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    //method converting DB Entity to DTO. Implementation creates at compile time.
    CarDTO carToCarDTO(Car car);

}
