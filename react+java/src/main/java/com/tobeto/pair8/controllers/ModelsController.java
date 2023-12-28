package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.ModelService;
import com.tobeto.pair8.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair8.services.dtos.model.responses.GetAllListModelRespose;
import com.tobeto.pair8.services.dtos.rental.responses.GetListRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService modelService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddModelRequest addModelRequest){
        modelService.add(addModelRequest);
    }

    @GetMapping("getmodels")
    public List<GetAllListModelRespose> getList(){
        return modelService.getAll();
    }
}
