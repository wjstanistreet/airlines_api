package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.PassengerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerServices passengerServices;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // London Heathrow
        Flight londonHeathrow = new Flight("London Heathrow", 8, "2022-12-05", "12:00");
        flightRepository.save(londonHeathrow);

        Passenger will = new Passenger("Will", "will@gmail.com");
//        will.addFlight(londonHeathrow);
        londonHeathrow.addPassenger(will);
        passengerRepository.save(will);

        Passenger steve = new Passenger("Steve", "steve@gmail.com");
//        steve.addFlight(londonHeathrow);
        londonHeathrow.addPassenger(steve);
        passengerRepository.save(steve);

        Passenger martha = new Passenger("Martha", "martha@gmail.com");
//        martha.addFlight(londonHeathrow);
        londonHeathrow.addPassenger(martha);
        passengerRepository.save(martha);


        // Paris Charles de Gaulle
        Flight parisCDG = new Flight("Paris Charles de Gaulle", 6, "2022-12-05", "16:00");
        flightRepository.save(parisCDG);

        Passenger olivia = new Passenger("Olivia", "olivia@outlook.com");
//        olivia.addFlight(parisCDG);
        parisCDG.addPassenger(olivia);
        passengerRepository.save(olivia);

        Passenger mac = new Passenger("Mac", "mac@hotmail.com");
//        mac.addFlight(parisCDG);
        parisCDG.addPassenger(mac);
        passengerRepository.save(mac);


        // New York JFK
        Flight newyorkJFK = new Flight("New York John F. Kennedy", 6, "2022-12-05", "18:00");
        flightRepository.save(newyorkJFK);

        Passenger johnny = new Passenger("Johnny", "johnny@aol.com");
//        johnny.addFlight(newyorkJFK);
        newyorkJFK.addPassenger(johnny);
        passengerRepository.save(johnny);

        // Multiple Destinations
        Passenger dennis = new Passenger("Dennis", "dennis@iasip.com");
//        dennis.addFlight(londonHeathrow);
//        dennis.addFlight(newyorkJFK);
        londonHeathrow.addPassenger(dennis);
        newyorkJFK.addPassenger(dennis);
        passengerRepository.save(dennis);

        Passenger deandre = new Passenger("Deandre", "deandre@gmail.com");
//        deandre.addFlight(parisCDG);
//        deandre.addFlight(newyorkJFK);
        parisCDG.addPassenger(deandre);
        newyorkJFK.addPassenger(deandre);
        passengerRepository.save(deandre);

        flightRepository.save(londonHeathrow);
        flightRepository.save(parisCDG);
        flightRepository.save(newyorkJFK);
    }
}
