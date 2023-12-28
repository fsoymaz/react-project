package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.BrandService;
import com.tobeto.pair8.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair8.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair8.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair8.services.dtos.brand.responses.GetAllListBrandResponse;
import com.tobeto.pair8.services.dtos.brand.responses.GetNameBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
@CrossOrigin
public class BrandsController {
    private BrandService brandService;

    @GetMapping("/getAll")
    public List<GetAllListBrandResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/brandName")
    public List<GetNameBrandResponse> getList() {
        return brandService.getList();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest){
        brandService.add(addBrandRequest);
    }


    @DeleteMapping("/delete")
    public  void delete(@RequestBody @Valid DeleteBrandRequest deleteBrandRequest){
        brandService.delete(deleteBrandRequest);
    }


    @PutMapping("/update")
    public void update (@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

}
