package com.uniloftsky.springframework.spring5filteredsearch.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Car extends BaseEntity {

    @ManyToOne
    private Model model;

    private String color;

}
