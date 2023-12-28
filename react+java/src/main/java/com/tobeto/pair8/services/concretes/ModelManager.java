package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair8.entities.Brand;
import com.tobeto.pair8.entities.Car;
import com.tobeto.pair8.entities.Model;
import com.tobeto.pair8.repositories.ModelRepository;
import com.tobeto.pair8.services.abstracts.BrandService;
import com.tobeto.pair8.services.abstracts.ModelService;
import com.tobeto.pair8.services.dtos.car.responses.GetAllListCarResponse;
import com.tobeto.pair8.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair8.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair8.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair8.services.dtos.model.responses.GetAllListModelRespose;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddModelRequest addModelRequest) {

        if (modelRepository.existsByName(addModelRequest.getName()))
        {
            throw new RuntimeException("Model Database'de Mevcuttur.");
        }

        Model model = this.modelMapperService.forRequest().map(addModelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
      Model modelToUpdate = modelRepository.findById(updateModelRequest.getId()).orElseThrow();

      this.modelMapperService.forRequest().map(updateModelRequest,modelToUpdate);

      modelRepository.saveAndFlush(modelToUpdate);
    }

    @Override
    public void delete(DeleteModelRequest deleteModelRequest) {
        Model modelToDelete= modelRepository.findById(deleteModelRequest.getId()).orElseThrow();
        modelRepository.delete(modelToDelete);

    }

    @Override
    public List<GetAllListModelRespose> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllListModelRespose> modelResposes = models.stream()
                .map(model -> this.modelMapperService
                        .forResponse().map(model, GetAllListModelRespose.class))
                .collect(Collectors.toList());
        return modelResposes;
    }

}
