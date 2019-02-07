package com.cognizant.devtest.airlineschedules.domain.repository;

import com.cognizant.devtest.airlineschedules.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
