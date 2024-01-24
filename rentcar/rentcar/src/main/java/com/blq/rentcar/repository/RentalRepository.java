package com.blq.rentcar.repository;

import com.blq.rentcar.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByIsActive(Boolean isActive);
}
