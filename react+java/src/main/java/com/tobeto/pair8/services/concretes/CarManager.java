package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair8.entities.Car;
import com.tobeto.pair8.repositories.CarRepository;
import com.tobeto.pair8.services.abstracts.CarService;
import com.tobeto.pair8.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair8.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair8.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair8.services.dtos.car.responses.GetAllListCarResponse;
import com.tobeto.pair8.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair8.services.dtos.car.responses.GetListCarResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllListCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllListCarResponse> carResponses = cars.stream()
                .map(car -> this.modelMapperService
                        .forResponse().map(car, GetAllListCarResponse.class))
                .collect(Collectors.toList());
        return carResponses;
    }


    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetByIdCarResponse carResponses = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
        return carResponses;
    }

    @Override
    public List<GetListCarResponse> getList() {
        List<Car> cars = carRepository.findAll();
        List<GetListCarResponse> carResponses = cars.stream().
                map(car -> this.modelMapperService
                        .forResponse().map(car,GetListCarResponse.class))
                .collect(Collectors.toList());

        return carResponses;
    }

    @Override
    public void add(AddCarRequest addCarRequest) {
        if (carRepository.existsByPlate(addCarRequest.getPlate()))
        {
            throw new RuntimeException("DB de aynı plakadan araç mevcuttur");
        }
        Car car = this.modelMapperService.forRequest().map(addCarRequest, Car.class);
        carRepository.save(car);
    }

    @Override
    public void delete(DeleteCarRequest deleteCarRequest) {
        // burada entitynotfound excption yaptım
        Car carToDelete = carRepository.findById(deleteCarRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Araç bulunamadı, ID: " + deleteCarRequest.getId()));

        carRepository.delete(carToDelete);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car carToUpdate = carRepository.findById(updateCarRequest.getId())
                .orElseThrow();

        this.modelMapperService.forRequest().map(updateCarRequest, carToUpdate);
        carRepository.saveAndFlush(carToUpdate);

    }
}
