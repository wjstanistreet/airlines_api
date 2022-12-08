package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.services.FlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightServices flightServices;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(@RequestParam(required = false, name = "destination") String destination){
        if (destination != null){
            List<Flight> flightsByDestination = flightServices.getAllFlightsByDestination(destination);
            return new ResponseEntity<>(flightsByDestination, HttpStatus.OK);
        }
        return new ResponseEntity<>(flightServices.getAllFlights(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        Optional<Flight> flight = flightServices.getFlightById(id);
        if (flight.isPresent()) {
            return new ResponseEntity<>(flight.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightServices.addFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@RequestBody Passenger passenger, @PathVariable Long id){
        flightServices.addPassengerToFlightById(id, passenger);
        return new ResponseEntity<>(flightServices.getFlightById(id).get(), HttpStatus.OK);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightServices.deleteFlightById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
