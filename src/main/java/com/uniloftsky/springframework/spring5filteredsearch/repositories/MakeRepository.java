package com.uniloftsky.springframework.spring5filteredsearch.repositories;

import com.uniloftsky.springframework.spring5filteredsearch.model.Make;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends CrudRepository<Make, Long> {
}
