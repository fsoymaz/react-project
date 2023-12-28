package com.tobeto.pair8.services.dtos.user.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListUserResponse {
    private String name;
    private String surName;
    private String eMail;


}
