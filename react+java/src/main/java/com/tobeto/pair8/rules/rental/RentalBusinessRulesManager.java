package com.tobeto.pair8.rules.rental;

import com.tobeto.pair8.repositories.RentalRepository;
import com.tobeto.pair8.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair8.services.dtos.rental.requests.AddRentalRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Service
public class RentalBusinessRulesManager implements RentalBusinessRulesService {
    private final RentalRepository rentalRepository;
    public void exceptionController(AddRentalRequest addRentalRequest)
    {
        if (addRentalRequest.getEndDate().isBefore(addRentalRequest.getStartDate())) {
            throw new RuntimeException("Bitiş tarihi başlangıç tarihinden önce olamaz");
        }
        if (rentalRepository.existsByCarIdAndDateRange(addRentalRequest.getCarId(),
                addRentalRequest.getStartDate(), addRentalRequest.getEndDate())) {
            throw new RuntimeException("Bu araç aynı tarih aralığında daha önce kiralanmış.");
        }
        if (ChronoUnit.DAYS.between(addRentalRequest.getStartDate(), addRentalRequest.getEndDate()) > 25) {
            throw new RuntimeException("25 günden fazla kiralama yapılamaz!");
        }



    }
}
