package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.entities.Brand;
import com.tobeto.pair8.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair8.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair8.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair8.services.dtos.brand.responses.GetAllListBrandResponse;
import com.tobeto.pair8.services.dtos.brand.responses.GetNameBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest addBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(DeleteBrandRequest deleteBrandRequest);

    List<GetAllListBrandResponse>getAll();

    List<GetNameBrandResponse>getList();


}
