package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServices {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public void addFlight(Flight flight){
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id){
        return flightRepository.findById(id);
    }

    public Optional<Flight> addPassengerToFlightById(Long id, Passenger passenger){
        Flight flight = flightRepository.findById(id).get();
        passengerRepository.save(passenger);
        flight.addPassenger(passenger);
        flightRepository.save(flight);
        return flightRepository.findById(id);
    }

    public Long deleteFlightById(Long id){
        flightRepository.deleteById(id);
        return id;
    }
}
