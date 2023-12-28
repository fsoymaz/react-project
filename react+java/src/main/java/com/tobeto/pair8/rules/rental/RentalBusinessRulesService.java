package com.tobeto.pair8.rules.rental;

import com.tobeto.pair8.services.dtos.rental.requests.AddRentalRequest;

public interface RentalBusinessRulesService {
    void exceptionController(AddRentalRequest addRentalRequest);
}
