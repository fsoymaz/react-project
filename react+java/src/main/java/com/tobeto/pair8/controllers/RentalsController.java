package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.RentalService;
import com.tobeto.pair8.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair8.services.dtos.rental.responses.GetListRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {
    private final RentalService rentalService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @GetMapping("getRentals")
    public List<GetListRentalResponse> getList(){
        return rentalService.getList();
    }
}
