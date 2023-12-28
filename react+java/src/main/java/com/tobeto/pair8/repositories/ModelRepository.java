package com.tobeto.pair8.repositories;

import com.tobeto.pair8.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByName(String name);
}
