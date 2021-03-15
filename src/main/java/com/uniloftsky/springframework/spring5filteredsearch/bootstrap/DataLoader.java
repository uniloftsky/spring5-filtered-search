package com.uniloftsky.springframework.spring5filteredsearch.bootstrap;

import com.uniloftsky.springframework.spring5filteredsearch.model.Car;
import com.uniloftsky.springframework.spring5filteredsearch.model.Make;
import com.uniloftsky.springframework.spring5filteredsearch.model.Model;
import com.uniloftsky.springframework.spring5filteredsearch.repositories.CarRepository;
import com.uniloftsky.springframework.spring5filteredsearch.repositories.MakeRepository;
import com.uniloftsky.springframework.spring5filteredsearch.repositories.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;

    public DataLoader(CarRepository carRepository, MakeRepository makeRepository, ModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.makeRepository = makeRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Make make = new Make();
        make.setName("BMW");
        makeRepository.save(make);
        Make make1 = new Make();
        make1.setName("Mercedes");
        makeRepository.save(make1);

        Model M5 = new Model();
        M5.setName("M5");
        M5.setMake(make);
        modelRepository.save(M5);

        Model model = new Model();
        model.setName("S500");
        model.setMake(make1);
        modelRepository.save(model);

        carRepository.save(new Car(M5, "black"));
        carRepository.save(new Car(M5, "red"));
        carRepository.save(new Car(M5, "green"));
        carRepository.save(new Car(M5, "green"));

        carRepository.save(new Car(model, "green"));
        carRepository.save(new Car(model, "green"));
    }
}
