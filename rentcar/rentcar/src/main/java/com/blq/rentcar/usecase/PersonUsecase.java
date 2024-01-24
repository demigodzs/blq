package com.blq.rentcar.usecase;

import com.blq.rentcar.models.Person;
import com.blq.rentcar.models.response.PersonsDto;
import com.blq.rentcar.models.response.ResponseInfo;
import com.blq.rentcar.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonUsecase {
    @Autowired
    private PersonRepository personRepository;

    public ResponseInfo<Object> addPerson(Person person)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            person.setCreatedBy("user_1");
            person.setCreatedDate(Date.from(Instant.now()));
            person.setIsActive(true);

            Person personData = this.personRepository.save(person);

            if (personData.getId() != null) {
                responseInfo.setSuccess();
            } else {
                responseInfo.setBadRequestException("Save failed, kindly check your request");
            }
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> getPersons()
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            List<Person> persons = this.personRepository.findByIsActive(true);

            List<PersonsDto> personsDtos = persons.stream()
                    .map(person -> new PersonsDto(
                            person.getName(),
                            person.getEmail(),
                            person.getAddress(),
                            person.getPhoneNumber()))
                    .collect(Collectors.toList());

            responseInfo.setSuccess(personsDtos);
        }
        catch (Exception e)
        {
            responseInfo.setException(e);
        }

        return responseInfo;
    }

    public ResponseInfo<Object> getPersonById(Long id)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Person> person = this.personRepository.findById(id);

            if(person.isPresent())
            {
                responseInfo.setSuccess(person);
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

    public ResponseInfo<Object> editPerson(Long id, Person person)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Person> personData = this.personRepository.findById(id);

            if(personData.isPresent())
            {
                person.setId(id);
                person.setModifyBy("user_2");
                person.setModifyDate(Date.from(Instant.now()));
                person.setCreatedBy(personData.get().getCreatedBy());
                person.setCreatedDate(personData.get().getCreatedDate());
                person.setIsActive(personData.get().getIsActive());
                this.personRepository.save(person);

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

    public ResponseInfo<Object> deletePerson(Long id)
    {
        ResponseInfo responseInfo = ResponseInfo.builder().build();
        try
        {
            Optional<Person> personData = this.personRepository.findById(id);

            if(personData.isPresent())
            {
                Person person = new Person();
                person.setId(id);
                person.setIsActive(false);
                person.setModifyBy("user_3");
                person.setModifyDate(Date.from(Instant.now()));
                person.setCreatedBy(personData.get().getCreatedBy());
                person.setCreatedDate(personData.get().getCreatedDate());
                person.setName(personData.get().getName());
                person.setEmail(personData.get().getEmail());
                person.setAddress(personData.get().getAddress());
                person.setPhoneNumber(personData.get().getPhoneNumber());
                this.personRepository.save(person);

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
