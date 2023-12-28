package com.tobeto.pair8.repositories;

import com.tobeto.pair8.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByNameAndSurName(String name, String surName);
    boolean existsByEmail(String email);
}
