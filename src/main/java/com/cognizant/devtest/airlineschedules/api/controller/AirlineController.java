package com.cognizant.devtest.airlineschedules.api.controller;

import com.cognizant.devtest.airlineschedules.domain.entity.Airline;
import com.cognizant.devtest.airlineschedules.domain.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {

    @Autowired
    private AirlineRepository airlineRepository;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Airline addAirline(@RequestBody Airline airline) throws Exception {

        Airline newAirline = airlineRepository.save(airline);

        return airlineRepository.findById(newAirline.getId()).orElseThrow(()->new Exception("airline not found"));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public Airline modifyAirline(@RequestBody Airline airline) throws Exception{

        Airline modifiedAirline = airlineRepository.save(airline);

        return airlineRepository.findById(modifiedAirline.getId()).orElseThrow(()-> new Exception("airline not found"));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Airline getAirlineById(@PathVariable("id") final Long id) throws Exception {

        Airline airline = airlineRepository.findById(id).orElseThrow(() -> new Exception("Airline not found"));

        return airline;
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Airline> getAllAirlines() {

        return airlineRepository.findAll();

    }


}
