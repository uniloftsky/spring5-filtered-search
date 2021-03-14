package com.uniloftsky.springframework.spring5filteredsearch.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Model extends BaseEntity {

    private String name;

    @ManyToOne
    private Make make;

}
