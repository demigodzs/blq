package com.blq.rentcar.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalsDto {
    private Date rentalDate;
    private Date returnDate;
    private PersonsDto person;
    private CarsDto car;
}
