package com.uniloftsky.springframework.spring5filteredsearch.services;

import com.uniloftsky.springframework.spring5filteredsearch.exceptions.NotFoundException;
import com.uniloftsky.springframework.spring5filteredsearch.model.Make;
import com.uniloftsky.springframework.spring5filteredsearch.repositories.MakeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MakeServiceImpl implements MakeService {

    private final MakeRepository makeRepository;

    public MakeServiceImpl(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    @Override
    public Make findById(Long id) {
        Optional<Make> makeOptional = makeRepository.findById(id);
        if(makeOptional.isEmpty()) {
            throw new NotFoundException("");
        }
        return null;
    }

    @Override
    public Set<Make> findAll() {
        return null;
    }

    @Override
    public Make save(Make obj) {
        return null;
    }

    @Override
    public void delete(Make obj) {

    }
}
