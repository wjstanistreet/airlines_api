package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServices {

    @Autowired
    FlightRepository flightRepository;

    public void addFlight(Flight flight){
        flightRepository.save(flight);
    }
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }
}
