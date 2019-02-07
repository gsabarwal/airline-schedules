package com.cognizant.devtest.airlineschedules.api.controller;

import com.cognizant.devtest.airlineschedules.domain.entity.Flight;
import com.cognizant.devtest.airlineschedules.domain.repository.FlightRepository;
import com.cognizant.devtest.airlineschedules.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Flight addFlight(@RequestBody Flight flight) throws Exception{
         flightService.createFlight(flight);

        Flight addedFlight = flightService.getFlightById(flight.getId());

        return addedFlight;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public Flight modifyFlight(@RequestBody Flight flight) throws Exception{

        Flight modifiedFlight = flightRepository.save(flight);

        return flightRepository.findById(modifiedFlight.getId()).orElseThrow(()->new Exception("flight not found"));
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
