package com.tobeto.pair8.services.dtos.car.responses;

import com.tobeto.pair8.services.dtos.color.resposes.GetAllListColorResponse;
import com.tobeto.pair8.services.dtos.model.responses.GetAllListModelRespose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllListCarResponse {
    private int id;
    private int kilometer;
    private String plate;
    private int year;
    private double dailyPrice;

    private GetAllListModelRespose modelRespose;
    private GetAllListColorResponse colorResponse;


}
