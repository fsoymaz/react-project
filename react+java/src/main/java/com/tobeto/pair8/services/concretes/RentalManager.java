package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair8.entities.Rental;
import com.tobeto.pair8.repositories.RentalRepository;
import com.tobeto.pair8.rules.rental.RentalBusinessRulesManager;
import com.tobeto.pair8.rules.rental.RentalBusinessRulesService;
import com.tobeto.pair8.services.abstracts.CarService;
import com.tobeto.pair8.services.abstracts.RentalService;
import com.tobeto.pair8.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair8.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair8.services.dtos.rental.responses.GetListRentalResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;
    private final RentalBusinessRulesService rentalBusinessRulesService;

    @Override
    public void add(AddRentalRequest addRentalRequest) {
        rentalBusinessRulesService.exceptionController(addRentalRequest);
        GetByIdCarResponse carResponse = carService.getById(addRentalRequest.getCarId());
        Rental rental = this.modelMapperService.forRequest().map(addRentalRequest, Rental.class);
        rental.setTotalPrice(TotalPrice(addRentalRequest.getStartDate(), addRentalRequest.getEndDate(), carResponse.getDailyPrice()));
        rental.setStartKilometer(carResponse.getKilometer());
        rentalRepository.save(rental);
    }

    @Override
    public List<GetListRentalResponse> getList() {
        List<Rental> rentals =rentalRepository.findAll();
        List<GetListRentalResponse> rentalResponses = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse().map(rental,GetListRentalResponse.class))
                .collect(Collectors.toList());
        return rentalResponses;
    }

    private double TotalPrice(LocalDate start, LocalDate end, double dailyPrice) {
        long daysBetween = start.until(end, ChronoUnit.DAYS);
        return daysBetween * dailyPrice;
    }
}
