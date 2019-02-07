package com.cognizant.devtest.airlineschedules.domain.repository;

import com.cognizant.devtest.airlineschedules.domain.entity.AirlineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AirlineScheduleRepository extends JpaRepository<AirlineSchedule, Long> {


}
