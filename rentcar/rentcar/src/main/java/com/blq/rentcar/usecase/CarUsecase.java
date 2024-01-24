package com.blq.rentcar.usecase;

import com.blq.rentcar.models.Car;
import com.blq.rentcar.models.response.ResponseInfo;
import com.blq.rentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CarUsecase {

    @Autowired
    public CarRepository carRepository;

    public ResponseInfo<Object> addCar(Car car)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            car.setCreatedBy("user_1");
            car.setCreatedDate(Date.from(Instant.now()));
            car.setIsActive(true);

            Car personData = this.carRepository.save(car);

            if(personData.equals(car))
            {
                responseInfo.setSuccess();
            }
            else
            {
                responseInfo.setBadRequestException("Save failed, kindly check your request");
            }
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> getCars()
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            List<Car> cars = this.carRepository.findByIsActive(true);

            responseInfo.setSuccess(cars);
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> getCarById(Long id)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Car> car = this.carRepository.findById(id);

            if(car.isPresent())
            {
                responseInfo.setSuccess(car);
            }
            else
            {
                responseInfo.setNotFoundException("Not found, please check your request.");
            }
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> editCar(Long id, Car car)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Car> carData = this.carRepository.findById(id);

            if(carData.isPresent())
            {
                car.setId(id);
                car.setModifyBy("user_2");
                car.setModifyDate(Date.from(Instant.now()));
                car.setCreatedBy(carData.get().getCreatedBy());
                car.setCreatedDate(carData.get().getCreatedDate());
                car.setIsActive(carData.get().getIsActive());
                this.carRepository.save(car);

                responseInfo.setSuccess();
            }
            else
            {
                responseInfo.setNotFoundException("Not found, please check your request.");
            }
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> deleteCar(Long id)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Car> carData = this.carRepository.findById(id);

            if(carData.isPresent())
            {
                Car car = new Car();
                car.setId(id);
                car.setIsActive(false);
                car.setModifyBy("user_3");
                car.setModifyDate(Date.from(Instant.now()));
                car.setCreatedBy(carData.get().getCreatedBy());
                car.setCreatedDate(carData.get().getCreatedDate());
                car.setBrand(carData.get().getBrand());
                car.setModel(carData.get().getModel());
                car.setYear(carData.get().getYear());
                this.carRepository.save(car);

                responseInfo.setSuccess();
            }
            else
            {
                responseInfo.setNotFoundException("Not found, please check your request.");
            }
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }
}
