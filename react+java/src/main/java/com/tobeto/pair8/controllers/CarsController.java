package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.CarService;
import com.tobeto.pair8.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair8.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair8.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair8.services.dtos.car.responses.GetAllListCarResponse;
import com.tobeto.pair8.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair8.services.dtos.car.responses.GetListCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor

public class CarsController {
private CarService carService;

    @GetMapping("/getAll")
    public List<GetAllListCarResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdCarResponse getById(@RequestParam @Valid int id){
        return carService.getById(id);
    }

    @GetMapping("/getList/")
    public List<GetListCarResponse> getList(){
        return carService.getList();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCarRequest addCarRequest){
        carService.add(addCarRequest);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteCarRequest deleteCarRequest){
        carService.delete(deleteCarRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCarRequest updateCarRequest){
        carService.update(updateCarRequest);
    }




}
