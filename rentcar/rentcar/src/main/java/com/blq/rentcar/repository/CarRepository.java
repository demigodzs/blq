package com.blq.rentcar.repository;

import com.blq.rentcar.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByIsActive(Boolean isActive);
}
