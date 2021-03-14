package com.uniloftsky.springframework.spring5filteredsearch.api.mapper;

import com.uniloftsky.springframework.spring5filteredsearch.api.model.ModelDTO;
import com.uniloftsky.springframework.spring5filteredsearch.model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
    ModelDTO modelToModelDTO(Model model);

}
