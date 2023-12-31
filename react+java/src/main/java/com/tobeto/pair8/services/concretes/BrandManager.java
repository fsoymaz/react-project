package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair8.entities.Brand;
import com.tobeto.pair8.entities.Car;
import com.tobeto.pair8.repositories.BrandRepository;
import com.tobeto.pair8.repositories.ModelRepository;
import com.tobeto.pair8.rules.brand.BrandBusinessRulesService;
import com.tobeto.pair8.services.abstracts.BrandService;
import com.tobeto.pair8.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair8.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair8.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair8.services.dtos.brand.responses.GetAllListBrandResponse;
import com.tobeto.pair8.services.dtos.brand.responses.GetNameBrandResponse;
import com.tobeto.pair8.services.dtos.car.responses.GetAllListCarResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private final BrandBusinessRulesService brandBusinessRulesService;
    @Override
    public void add(AddBrandRequest addBrandRequest) {
        brandBusinessRulesService.exceptionSameName(addBrandRequest);
        Brand brand = this.modelMapperService.forRequest().map(addBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        brandBusinessRulesService.exceptionSameName(updateBrandRequest);
        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId())
                .orElseThrow(()-> new EntityNotFoundException("Araç id bulunamadı : ID" + updateBrandRequest));

        this.modelMapperService.forRequest().map(updateBrandRequest,brandToUpdate);

        brandRepository.saveAndFlush(brandToUpdate);
    }

    @Override
    public void delete(DeleteBrandRequest deleteBrandRequest) {
        Brand brandToDelete = brandRepository.findById(deleteBrandRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Araç bulunamadı, ID: " + deleteBrandRequest.getId()));

        brandRepository.delete(brandToDelete);

    }

    @Override
    public List<GetAllListBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllListBrandResponse> brandResponses = brands.stream()
                .map(brand -> this.modelMapperService
                        .forResponse().map(brand, GetAllListBrandResponse.class))
                .collect(Collectors.toList());
        return brandResponses;
    }

    @Override
    public List<GetNameBrandResponse> getList() {
        List<Brand> brands = brandRepository.findAll();
        List<GetNameBrandResponse> brandResponses = brands.stream()
                .map(brand -> this.modelMapperService
                        .forResponse().map(brand, GetNameBrandResponse.class))
                .collect(Collectors.toList());

        return brandResponses;
    }

}
