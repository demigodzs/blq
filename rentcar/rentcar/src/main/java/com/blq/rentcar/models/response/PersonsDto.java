package com.blq.rentcar.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonsDto {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}
