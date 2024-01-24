package com.blq.rentcar.usecase;

import com.blq.rentcar.models.Car;
import com.blq.rentcar.models.Person;
import com.blq.rentcar.models.Rental;
import com.blq.rentcar.models.request.RentalAddRequest;
import com.blq.rentcar.models.request.RentalReturnRequest;
import com.blq.rentcar.models.response.CarsDto;
import com.blq.rentcar.models.response.PersonsDto;
import com.blq.rentcar.models.response.RentalsDto;
import com.blq.rentcar.models.response.ResponseInfo;
import com.blq.rentcar.repository.CarRepository;
import com.blq.rentcar.repository.PersonRepository;
import com.blq.rentcar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RentalUsecase {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CarRepository carRepository;

    public ResponseInfo<Object> addRental(RentalAddRequest rentalAddRequest)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Rental rental = new Rental();

            Optional<Person> personData = this.personRepository.findById(rentalAddRequest.getUserId());
            Optional<Car> carData = this.carRepository.findById(rentalAddRequest.getCarId());

            if (personData.isPresent() && carData.isPresent()) {
                Person person = personData.get();
                Car car = carData.get();

                rental.setPerson(person);
                rental.setCar(car);

                rental.setId(rentalAddRequest.getId());
                rental.setRentalDate(rentalAddRequest.getRentalDate());
                rental.setReturnDate(rentalAddRequest.getReturnDate());
                rental.setCreatedBy("user_1");
                rental.setCreatedDate(Date.from(Instant.now()));
                rental.setIsActive(true);

                Rental savedRental = this.rentalRepository.save(rental);

                if (savedRental.getId() != null) {
                    responseInfo.setSuccess();
                } else {
                    responseInfo.setBadRequestException("Save failed, kindly check your request");
                }
            } else {
                responseInfo.setBadRequestException("Person or Car not found with provided IDs");
            }
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> getRentals()
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            List<Rental> rentals = this.rentalRepository.findByIsActive(true);

            List<RentalsDto> rentalsDtos = rentals.stream()
                    .map(rental -> new RentalsDto(
                            rental.getRentalDate(),
                            rental.getReturnDate(),
                            new PersonsDto(rental.getPerson().getName(),
                                    rental.getPerson().getEmail(),
                                    rental.getPerson().getAddress(),
                                    rental.getPerson().getPhoneNumber()),
                            new CarsDto(rental.getCar().getBrand(),
                                    rental.getCar().getModel(),
                                    rental.getCar().getYear())))
                    .collect(Collectors.toList());

            responseInfo.setSuccess(rentalsDtos);
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> getRentalById(Long id)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Rental> rental = this.rentalRepository.findById(id);

            if(rental.isPresent())
            {
                responseInfo.setSuccess(rental);
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

    public ResponseInfo<Object> returnCar(Long id, RentalReturnRequest rentalReturnRequest)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Rental> rentalData = this.rentalRepository.findById(id);

            Rental rental = new Rental();
            rental.setId(id);
            rental.setPerson(rentalData.get().getPerson());
            rental.setCar(rentalData.get().getCar());
            rental.setRentalDate(rentalData.get().getRentalDate());
            rental.setReturnDate(rentalReturnRequest.getReturnDate());
            rental.setIsActive(rentalData.get().getIsActive());
            rental.setModifyBy("user_2");
            rental.setModifyDate(Date.from(Instant.now()));
            rental.setCreatedBy(rentalData.get().getCreatedBy());
            rental.setCreatedDate(rentalData.get().getCreatedDate());
            this.rentalRepository.save(rental);

            responseInfo.setSuccess();
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> deleteRental(Long id)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Rental> rentalData = this.rentalRepository.findById(id);

            if(rentalData.isPresent())
            {
                Rental rental = new Rental();
                rental.setId(id);
                rental.setPerson(rentalData.get().getPerson());
                rental.setCar(rentalData.get().getCar());
                rental.setRentalDate(rentalData.get().getRentalDate());
                rental.setReturnDate(rentalData.get().getReturnDate());
                rental.setIsActive(false);
                rental.setModifyBy("user_3");
                rental.setModifyDate(Date.from(Instant.now()));
                rental.setCreatedBy(rentalData.get().getCreatedBy());
                rental.setCreatedDate(rentalData.get().getCreatedDate());
                this.rentalRepository.save(rental);

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