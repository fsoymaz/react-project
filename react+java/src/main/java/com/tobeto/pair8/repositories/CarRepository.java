package com.tobeto.pair8.repositories;

import com.tobeto.pair8.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String plate);
}
