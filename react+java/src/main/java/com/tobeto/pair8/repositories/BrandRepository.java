package com.tobeto.pair8.repositories;

import com.tobeto.pair8.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);


    boolean existsById(int id);
}
