package com.uniloftsky.springframework.spring5filteredsearch.services;

import com.uniloftsky.springframework.spring5filteredsearch.model.Make;

import java.util.Set;

public interface MakeService extends GenericService<Make, Long> {

    Make findById(Long id);
    Set<Make> findAll();
    Make save(Make obj);
    void delete(Make obj);

}
