package com.uniloftsky.springframework.spring5filteredsearch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car extends BaseEntity {

    public Car(Model model, String color) {
        this.model = model;
        this.color = color;
    }

    @ManyToOne
    private Model model;

    private String color;
}
