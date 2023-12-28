package com.tobeto.pair8.repositories;

import com.tobeto.pair8.entities.Rental;
import com.tobeto.pair8.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Query("SELECT COUNT(r) > 0 FROM Rental r WHERE r.car.id = :carId AND " +
            "((r.startDate <= :endDate AND r.endDate >= :startDate) OR " +
            "(r.startDate <= :startDate AND r.endDate >= :endDate))")
    boolean existsByCarIdAndDateRange(
            @Param("carId") int carId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
