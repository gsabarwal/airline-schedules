package com.cognizant.devtest.airlineschedules.service;

import com.cognizant.devtest.airlineschedules.domain.entity.Flight;
import com.cognizant.devtest.airlineschedules.domain.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;


    public Flight createFlight(Flight flight) {
        return flightRepository.saveAndFlush(flight);
    }

    public Flight getFlightById(Long id) throws Exception {
        return flightRepository.findById(id).orElseThrow(() -> new Exception("flight not found"));
    }
}
