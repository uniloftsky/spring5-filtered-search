package com.uniloftsky.springframework.spring5filteredsearch.api.mapper;

import com.uniloftsky.springframework.spring5filteredsearch.api.model.MakeDTO;
import com.uniloftsky.springframework.spring5filteredsearch.model.Make;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MakeMapper {

    MakeMapper INSTANCE = Mappers.getMapper(MakeMapper.class);
    MakeDTO makeToMaleDTO(Make make);

}
