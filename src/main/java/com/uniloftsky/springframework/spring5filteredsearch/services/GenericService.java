package com.uniloftsky.springframework.spring5filteredsearch.services;

import java.util.Set;

public interface GenericService<T, ID> {

    T findById(ID id);
    Set<T> findAll();
    T save(T obj);
    void delete(T obj);

}
