# spring5-filtered-search
Cheatsheet with using filtered search in Spring Framework. Example is presented with REST.

MapStruct is used for converting DB Entity to DTO.<br><br>
CarMapper interface:
```java
package com.uniloftsky.springframework.spring5filteredsearch.api.mapper;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    //method converting DB Entity to DTO. Implementation creates at compile time.
    CarDTO carToCarDTO(Car car);

}
```
Car class (BaseEntity class manages id property):
```java
package com.uniloftsky.springframework.spring5filteredsearch.model;

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
    private final Model model;

    private final String color;
}
```

Make class:
```java
package com.uniloftsky.springframework.spring5filteredsearch.model;

@Getter
@Setter
@Entity
public class Make extends BaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "make", fetch = FetchType.EAGER)
    private final Set<Model> models = new HashSet<>();

}
```

Model class:
```java
package com.uniloftsky.springframework.spring5filteredsearch.model;

@Getter
@Setter
@Entity
public class Model extends BaseEntity {

    private String name;

    @ManyToOne
    private Make make;

}
```

CarDTO class:
```java
package com.uniloftsky.springframework.spring5filteredsearch.api.model;

@Getter
@Setter
public class CarDTO {

    private ModelDTO model;
    private String color;

}
```
MakeDTO class:
```java
package com.uniloftsky.springframework.spring5filteredsearch.api.model;

@Getter
@Setter
public class MakeDTO {

    private String name;

}
```
ModelDTO class:
```java
package com.uniloftsky.springframework.spring5filteredsearch.api.model;

@Getter
@Setter
public class ModelDTO {

    private String name;
    private MakeDTO make;

}
```

CarSearchCriteria class has properties which will be used for filtering.
```java
package com.uniloftsky.springframework.spring5filteredsearch.filter;

@Getter
@Setter
public class CarSearchCriteria {

    private String makeName;
    private String modelName;
    private String color;

}
```

Filter method in CarCriteriaRepository. Here we need to filter cars.<br>
carRoot - DB Entity,<br>
carSearchCriteria - Our class with search criteria.
```java
private Predicate getPredicate(CarSearchCriteria carSearchCriteria,
                                   Root<Car> carRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(carSearchCriteria.getModelName())) {
            predicates.add(
                    criteriaBuilder.like(carRoot.get("model").get("name"),
                            "%" + carSearchCriteria.getModelName() + "%")
            );
        }
        if (Objects.nonNull(carSearchCriteria.getMakeName())) {
            predicates.add(
                    //if need to use bean with references to other beans. Property like a string
                    criteriaBuilder.like(carRoot.get("model").get("make").get("name"),
                            "%" + carSearchCriteria.getMakeName() + "%")
            );
        }
        if (Objects.nonNull(carSearchCriteria.getColor())) {
            predicates.add(
                    criteriaBuilder.like(carRoot.get("color"),
                            "%" + carSearchCriteria.getColor() + "%")
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
```

Converting from DB Entity to DTO:
```java
@Override
public Page<CarDTO> getFilteredCars(CarPage carPage, CarSearchCriteria carSearchCriteria) {
    List<CarDTO> carDTOList = new ArrayList<>();
    //getting cars from carCriteriaRepository and converting them to DTO, returning list with DTOs. Then controller uses this method
    carCriteriaRepository.findAllWithFilters(carPage, carSearchCriteria)
        .forEach(car -> carDTOList.add(carMapper.carToCarDTO(car)));
    return new PageImpl<>(carDTOList);
}
```

Output with http://localhost:8080/cars?modelName=S500
```json
"content": [
        {
            "model": {
                "name": "S500",
                "make": {
                    "name": "Mercedes"
                }
            },
            "color": "green"
        },
        {
            "model": {
                "name": "S500",
                "make": {
                    "name": "Mercedes"
                }
            },
            "color": "green"
        }
    ],
```

