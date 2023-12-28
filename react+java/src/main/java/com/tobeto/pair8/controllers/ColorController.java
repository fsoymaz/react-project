package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.ColorService;
import com.tobeto.pair8.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair8.services.dtos.color.resposes.GetAllListColorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/color")
@AllArgsConstructor

public class ColorController {
    private ColorService colorService;
    @GetMapping("/getAll")
    public List<GetAllListColorResponse> getAll()
    {
        return colorService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddColorRequest addColorRequest)
    {
        colorService.add(addColorRequest);
    }
}
