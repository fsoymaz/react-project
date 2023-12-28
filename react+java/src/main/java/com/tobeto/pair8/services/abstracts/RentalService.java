package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair8.services.dtos.rental.responses.GetListRentalResponse;

import java.util.List;

public interface RentalService {
    void add(AddRentalRequest addRentalRequest);

    List<GetListRentalResponse> getList();
}
