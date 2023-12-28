package com.tobeto.pair8.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddBrandRequest {
    @NotBlank(message = "Marka alanı boş olamaz!!!")
    @Size(min = 2, message = "Marka Alanı en az iki karakterden oluşmalıdır.")
    private String name;

}
