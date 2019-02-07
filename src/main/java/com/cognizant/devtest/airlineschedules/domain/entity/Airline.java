package com.cognizant.devtest.airlineschedules.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", precision = 19)
    private Long id;


    @Column(name = "CODE", nullable = false, length = 25)
    private String code;

    @Column(name = "NAME", nullable = false, length = 255)
    private String name;

/*
    @OneToMany(mappedBy = "airline")
    private List<Flight> flightList;


*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
