package com.blq.rentcar.controller;

import com.blq.rentcar.models.Car;
import com.blq.rentcar.models.response.ResponseInfo;
import com.blq.rentcar.usecase.CarUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class CarController {
    @Autowired
    CarUsecase carUsecase;

    @PostMapping("cars/add")
    public ResponseEntity<?> addCar(
            @RequestBody Car car
    ){
        ResponseInfo<Object> responseInfo = carUsecase.addCar(car);
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @GetMapping("cars")
    public ResponseEntity<?> getAllCar(){
        ResponseInfo<Object> responseInfo = carUsecase.getCars();
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @GetMapping("cars/{id}")
    public ResponseEntity<?> getCarById(
            @PathVariable("id") Long id
    ){
        ResponseInfo<Object> responseInfo = carUsecase.getCarById(id);
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @PutMapping("cars/edit/{id}")
    public ResponseEntity<?> editCar(
            @PathVariable("id") Long id,
            @RequestBody Car car
    ){
        ResponseInfo<Object> responseInfo = carUsecase.editCar(id, car);
        return  new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @PutMapping("cars/delete/{id}")
    public ResponseEntity<?> deleteCar(
            @PathVariable("id") Long id
    ){
        ResponseInfo<Object> responseInfo = carUsecase.deleteCar(id);
        return  new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }
}
