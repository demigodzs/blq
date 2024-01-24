package com.blq.rentcar.controller;

import com.blq.rentcar.models.Car;
import com.blq.rentcar.models.request.RentalAddRequest;
import com.blq.rentcar.models.request.RentalReturnRequest;
import com.blq.rentcar.models.response.ResponseInfo;
import com.blq.rentcar.usecase.RentalUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class RentalController {
    @Autowired
    RentalUsecase rentalUsecase;

    @PostMapping("rentals/add")
    public ResponseEntity<?> addRental(
            @RequestBody RentalAddRequest rentalAddRequest
    ){
        ResponseInfo<Object> responseInfo = rentalUsecase.addRental(rentalAddRequest);
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @GetMapping("rentals")
    public ResponseEntity<?> getAllRental(){
        ResponseInfo<Object> responseInfo = rentalUsecase.getRentals();
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @GetMapping("rentals/{id}")
    public ResponseEntity<?> getRentalById(
            @PathVariable("id") Long id
    ){
        ResponseInfo<Object> responseInfo = rentalUsecase.getRentalById(id);
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @PutMapping("rentals/return-car/{id}")
    public ResponseEntity<?> returnCar(
            @PathVariable("id") Long id,
            @RequestBody RentalReturnRequest rentalReturnRequest
    ){
        ResponseInfo<Object> responseInfo = rentalUsecase.returnCar(id, rentalReturnRequest);
        return  new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @PutMapping("rentals/delete/{id}")
    public ResponseEntity<?> deleteRental(
            @PathVariable("id") Long id
    ){
        ResponseInfo<Object> responseInfo = rentalUsecase.deleteRental(id);
        return  new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }
}
