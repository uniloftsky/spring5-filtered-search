package com.uniloftsky.springframework.spring5filteredsearch.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Make extends BaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "make", fetch = FetchType.EAGER)
    private Set<Model> models = new HashSet<>();

}
