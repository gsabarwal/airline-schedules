package com.cognizant.devtest.airlineschedules.domain.repository;

import com.cognizant.devtest.airlineschedules.domain.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
