package com.blq.rentcar.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalAddRequest {
    private Long id;
    private Long userId;
    private Long carId;
    private Date rentalDate;
    private Date returnDate;
}
