package com.cognizant.devtest.airlineschedules.api.controller;

import com.cognizant.devtest.airlineschedules.domain.entity.AirlineSchedule;
import com.cognizant.devtest.airlineschedules.domain.entity.Flight;
import com.cognizant.devtest.airlineschedules.domain.repository.AirlineScheduleRepository;
import com.cognizant.devtest.airlineschedules.domain.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airline-schedule")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineScheduleController {

    @Autowired
    private AirlineScheduleRepository airlineScheduleRepository;

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public AirlineSchedule addAirlineSchedule(@RequestBody AirlineSchedule airlineSchedule) throws Exception {

        List<Flight> flights = airlineSchedule.getFlightList();

        List<Flight> dbFlights = new ArrayList<Flight>();

        for (Flight flight : flights) {
            Flight flightFromDb = flightRepository.findById(flight.getId()).orElseThrow(() -> new Exception("No flight found"));
            dbFlights.add(flightFromDb);
        }

        airlineSchedule.setFlightList(dbFlights);

        AirlineSchedule newAirlineSchedule = airlineScheduleRepository.save(airlineSchedule);

        return newAirlineSchedule;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public AirlineSchedule modofyAirlineSchedule(@RequestBody AirlineSchedule airlineSchedule) throws Exception {

        List<Flight> flights = airlineSchedule.getFlightList();

        List<Flight> dbFlights = new ArrayList<Flight>();

        for (Flight flight : flights) {
            Flight flightFromDb = flightRepository.findById(flight.getId()).orElseThrow(() -> new Exception("No flight found"));
            dbFlights.add(flightFromDb);
        }

        airlineSchedule.setFlightList(dbFlights);

        AirlineSchedule newAirlineSchedule = airlineScheduleRepository.save(airlineSchedule);

        return newAirlineSchedule;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public AirlineSchedule getAirlineSchedule(@PathVariable("id") final Long id) throws Exception {


        AirlineSchedule airlineSchedule = airlineScheduleRepository.findById(id).orElseThrow(() -> new Exception("No flight found"));

        return airlineSchedule;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<AirlineSchedule> getAllAirlineSchedules() {


        return airlineScheduleRepository.findAll();

    }

}
