package com.blq.rentcar.repository;

import com.blq.rentcar.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByIsActive(Boolean isActive);
}
