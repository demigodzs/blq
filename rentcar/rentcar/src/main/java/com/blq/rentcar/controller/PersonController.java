package com.blq.rentcar.controller;

import com.blq.rentcar.models.Person;
import com.blq.rentcar.models.response.ResponseInfo;
import com.blq.rentcar.usecase.PersonUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class PersonController {
    @Autowired
    public PersonUsecase personUsecase;

    @PostMapping("persons/add")
    public ResponseEntity<?> addPerson(
            @RequestBody Person person
    ){
        ResponseInfo<Object> responseInfo = personUsecase.addPerson(person);
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @GetMapping("persons")
    public ResponseEntity<?> getAllPerson(){
        ResponseInfo<Object> responseInfo = personUsecase.getPersons();
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @GetMapping("persons/{id}")
    public ResponseEntity<?> getPersonById(
            @PathVariable("id") Long id
    ){
        ResponseInfo<Object> responseInfo = personUsecase.getPersonById(id);
        return new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @PutMapping("persons/edit/{id}")
    public ResponseEntity<?> editPerson(
            @PathVariable("id") Long id,
            @RequestBody Person person
    ){
        ResponseInfo<Object> responseInfo = personUsecase.editPerson(id, person);
        return  new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }

    @PutMapping("persons/delete/{id}")
    public ResponseEntity<?> deletePerson(
            @PathVariable("id") Long id
    ){
        ResponseInfo<Object> responseInfo = personUsecase.deletePerson(id);
        return  new ResponseEntity<>(responseInfo.getBody(),
                responseInfo.getHttpHeaders(),
                responseInfo.getHttpStatus());
    }
}
