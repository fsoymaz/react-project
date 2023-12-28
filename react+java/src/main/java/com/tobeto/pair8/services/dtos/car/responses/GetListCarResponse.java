package com.tobeto.pair8.services.dtos.car.responses;

import com.tobeto.pair8.services.dtos.brand.responses.GetAllListBrandResponse;
import com.tobeto.pair8.services.dtos.brand.responses.GetNameBrandResponse;
import com.tobeto.pair8.services.dtos.color.resposes.GetAllListColorResponse;
import com.tobeto.pair8.services.dtos.color.resposes.GetColorNameResponse;
import com.tobeto.pair8.services.dtos.model.responses.GetAllListModelRespose;
import com.tobeto.pair8.services.dtos.model.responses.GetModelNameResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarResponse {

    private int kilometer;
    private String plate;
    private int year;
    private double dailyPrice;

    private GetModelNameResponse modelNameResponse;
    private GetColorNameResponse colorNameResponse;
    private GetNameBrandResponse brandNameResponse;


}
