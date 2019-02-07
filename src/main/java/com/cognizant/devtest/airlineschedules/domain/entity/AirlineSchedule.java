package com.cognizant.devtest.airlineschedules.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class AirlineSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", precision = 19)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "originAirportID")
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "destinationAirportID")
    private Airport destinationAirport;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.ALL
            })
    @JoinTable(name = "airline_schedule_map",
            joinColumns = {@JoinColumn(name = "schedule_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id")})
    private List<Flight> flightList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
}
