package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair8.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair8.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair8.services.dtos.car.responses.GetAllListCarResponse;
import com.tobeto.pair8.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair8.services.dtos.car.responses.GetListCarResponse;

import java.util.List;

public interface    CarService {

    void add(AddCarRequest addCarRequest);
    void delete(DeleteCarRequest deleteCarRequest);
    void update(UpdateCarRequest updateCarRequest);

    List<GetAllListCarResponse> getAll();

    GetByIdCarResponse getById(int id);


    List<GetListCarResponse> getList();
}
