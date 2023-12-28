package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair8.entities.Color;
import com.tobeto.pair8.repositories.ColorRepository;
import com.tobeto.pair8.services.abstracts.ColorService;
import com.tobeto.pair8.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair8.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair8.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair8.services.dtos.color.resposes.GetAllListColorResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddColorRequest addColorRequest) {
       if (colorRepository.existsByName(addColorRequest.getName()))
            throw new RuntimeException("Aynı renk iki kez eklenemez");

        Color color = this.modelMapperService.forRequest().map(addColorRequest, Color.class);
        colorRepository.save(color);
    }
    @Override
    public void update(UpdateColorRequest updateColorRequest) {
     Color colorToUpate =colorRepository.findById(updateColorRequest.getId()).orElseThrow();

     this.modelMapperService.forRequest().map(updateColorRequest,colorToUpate);
     colorRepository.saveAndFlush(colorToUpate);

    }

    @Override
    public void delete(DeleteColorRequest deleteColorRequest) {
        Color colorToDelete = colorRepository.findById(deleteColorRequest.getId()).orElseThrow();
        colorRepository.delete(colorToDelete);


    }

    @Override
    public List<GetAllListColorResponse> getAll() {
        List <Color> colors = colorRepository.findAll();
        List<GetAllListColorResponse>colorResponses = colors.stream()
                .map(color -> this.modelMapperService.forResponse().map(color,GetAllListColorResponse.class))
                .collect(Collectors.toList());

        return colorResponses;
    }


}
