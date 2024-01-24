package com.blq.rentcar.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsDto {
    private String brand;
    private String model;
    private Integer year;
}
