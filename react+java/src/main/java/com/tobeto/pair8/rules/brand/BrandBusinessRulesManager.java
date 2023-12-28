package com.tobeto.pair8.rules.brand;

import com.tobeto.pair8.repositories.BrandRepository;
import com.tobeto.pair8.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair8.services.dtos.brand.requests.UpdateBrandRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BrandBusinessRulesManager implements BrandBusinessRulesService{
    private final BrandRepository brandRepository;

    @Override
    public void exceptionSameName(AddBrandRequest addBrandRequest) {
        if (brandRepository.existsByName(addBrandRequest.getName()))
        {
            throw new RuntimeException("Marka Database'de Mevcuttur.");
        }
    }
    @Override
    public void exceptionSameName(UpdateBrandRequest updateBrandRequest) {
        if (brandRepository.existsByName(updateBrandRequest.getName()))
        {
            throw new RuntimeException("Marka Database'de Mevcuttur.");
        }
    }
    }

