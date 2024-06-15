package com.sena.back_1076502369.Entity;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Routes extends ABaseEntity{
    @Column(name = "distance")
    private Double distance;

    @Column(name = "flight_time")
    private Time flighTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airports departure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airports arrival;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Time getFlighTime() {
        return flighTime;
    }

    public void setFlighTime(Time flighTime) {
        this.flighTime = flighTime;
    }

    public Airports getDeparture() {
        return departure;
    }

    public void setDeparture(Airports departure) {
        this.departure = departure;
    }

    public Airports getArrival() {
        return arrival;
    }

    public void setArrival(Airports arrival) {
        this.arrival = arrival;
    }
    
}