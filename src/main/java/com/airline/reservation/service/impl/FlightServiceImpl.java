package com.airline.reservation.service.impl;


import com.airline.reservation.domain.*;
import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;
import com.airline.reservation.exception.EmailFailureException;
import com.airline.reservation.exception.FlightNotFoundException;
import com.airline.reservation.repository.AirlineRepository;
import com.airline.reservation.repository.AirportRepository;
import com.airline.reservation.repository.FlightRepository;
import com.airline.reservation.repository.ReservationRepository;
import com.airline.reservation.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class FlightServiceImpl implements FlightService {


    private JavaMailSender javaMailSender = new JavaMailSenderImpl();

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirportRepository airportRepository;


    @Override
    public FlightResponse addFlight(FlightRequest flightRequest) {
        Airline airline= airlineRepository.findByCode(flightRequest.getAirlineCode());
        Airport departureAirport= airportRepository.findByCode(flightRequest.getDepartureAirport());
        Airport originAirport= airportRepository.findByCode(flightRequest.getArrivalAirport());

        Flight flight=new Flight();
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(originAirport);
        flight.setFlightNumber(flightRequest.getFlightNumber());
        flight.setCapacity(flightRequest.getCapacity());
        flight.setDepartureTime(flightRequest.getDepartureTime());
        flight.setDepartureDate(flightRequest.getDepartureDate());
        flight.setArrivalTime(flightRequest.getArrivalTime());
        flight.setArrivalDate(flightRequest.getArrivalDate());
        flight.setAirline(airline);

        return covertFlightToFlightResponse(flightRepository.save(flight));
    }

    @Override
    public FlightResponse getFlightByNumber(Integer flightNumber) {
        return covertFlightToFlightResponse(flightRepository.getByFlightNumber(flightNumber));
    }

    @Override
    public List<FlightResponse> getAllFlights() {
        return flightRepository.findAll().stream().parallel().map(this::covertFlightToFlightResponse).collect(Collectors.toList());

    }

    private FlightResponse covertFlightToFlightResponse(Flight flight){
        String departureAirportName = flight.getDepartureAirport() == null?null:flight.getDepartureAirport().getName();
        String arrivalAirportName = flight.getArrivalAirport() == null?null:flight.getArrivalAirport().getName();
        String airlineCode = flight.getAirline() == null?null:flight.getAirline().getName();
        return new FlightResponse(flight.getId(), flight.getFlightNumber(), flight.getCapacity(), departureAirportName, flight.getDepartureTime(),flight.getDepartureDate(),arrivalAirportName,flight.getArrivalTime(),flight.getArrivalDate(), airlineCode);

    }


    @Override
    public Flight getFlightByPassengerId(Integer passengerId) {
        Flight flight = null;
        Set<Integer> flightNumbers = reservationRepository.findFlightNumbers(passengerId);
        System.out.println("First: " + flightNumbers);

        for(int flightNumber : flightNumbers) {
            flight = flightRepository.getByFlightNumber(flightNumber);
        }
        System.out.println("Second: " + flight);
        return flight;
    }

    public void sendEmail() throws EmailFailureException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("dummy@gmail.com");
        message.setSubject("Dummy Subject");
        message.setText("Just Dummy Text");

        javaMailSender.send(message);
    }

    public boolean checkSeatAvailability(int flightId) {
        boolean fullStatus = false;
        Optional<Flight> flight = flightRepository.findById((long) flightId);

        if(!flight.isPresent()) {
            Flight currentFlight = flight.get();
            if(currentFlight.getSeatsAvailable() > 0) {
                fullStatus = true;
            }
        }

        return fullStatus;
    }

    public void handleEmail(Reservation reservation, Passenger passenger) {
        System.out.println("=========================");
        System.out.println("=======Send Email========");
        System.out.println("=========================");
        System.out.println("Passenger: " + passenger.getEmail());
        System.out.println("Reservation: " + reservation.getId());

        try{
            sendEmail();
        }catch (EmailFailureException ex) {
            throw ex;
        }
    }

    @Override
    public void bookFlight(int flightId, Passenger passenger) {
        Optional<Flight> flight = flightRepository.findById((long) flightId);

        if(!flight.isPresent())
            throw new FlightNotFoundException("Flight not found");

        if(checkSeatAvailability(flightId) == true) {
            Flight currentFlight = flight.get();
            Reservation booking = new Reservation();

            booking.setConfirmed(true);
            booking.setPassengerId(passenger.getId());
            reservationRepository.save(booking);

            Integer currentSeats = currentFlight.getSeatsAvailable();
            currentFlight.setSeatsAvailable(currentSeats - 1);
            flightRepository.save(currentFlight);

            handleEmail(booking, passenger);
        } else {
            System.out.println("Flight is full");
        }

    }

}
