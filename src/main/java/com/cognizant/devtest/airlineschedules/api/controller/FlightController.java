package com.cognizant.devtest.airlineschedules.api.controller;

import com.cognizant.devtest.airlineschedules.domain.entity.Flight;
import com.cognizant.devtest.airlineschedules.domain.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Flight addFlight(@RequestBody Flight flight) {

        Flight newFlight = flightRepository.save(flight);

        return newFlight;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public Flight modifyFlight(@RequestBody Flight flight) {

        Flight modifiedFlight = flightRepository.save(flight);

        return modifiedFlight;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Flight getFlightById(@PathVariable("id") final Long id) throws Exception {

        Flight flight = flightRepository.findById(id).orElseThrow(() -> new Exception("Flight not found"));

        return flight;
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Flight> getAllFlights() {

        return flightRepository.findAll();

    }

}
