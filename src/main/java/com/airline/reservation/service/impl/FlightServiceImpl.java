package com.airline.reservation.service.impl;


import com.airline.reservation.domain.*;
import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;
import com.airline.reservation.exception.EmailFailureException;
import com.airline.reservation.exception.FlightNotFoundException;
import com.airline.reservation.repository.*;
import com.airline.reservation.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private TicketRepository ticketRepository;



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
        return new FlightResponse(flight.getId(), flight.getFlightNumber(), flight.getCapacity(), flight.getDepartureAirport().getCode(), flight.getDepartureTime(),flight.getDepartureDate(),flight.getArrivalAirport().getCode(),flight.getArrivalTime(),flight.getArrivalDate(), flight.getAirline().getCode());
    }


    @Override
    public Flight getFlightByPassengerId(Integer passengerId) {
        Ticket passengerTicket = ticketRepository.findTicketByPassengerId((long)passengerId);
        System.out.println("========================= Ticket: " + passengerTicket.getId());
        Flight flight = flightRepository.getFlightById(passengerTicket.getId());

        return flight;
    }

    public void sendEmail() throws EmailFailureException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("elgordofifa@gmail.com");
        message.setSubject("Dummy Subject");
        message.setText("Just Dummy Text");
        System.out.println("========================= Message To Send: " + message.getSubject());

        javaMailSender.send(message);
    }

    public boolean checkSeatAvailability(int flightId) {
        boolean fullStatus = false;
        Optional<Flight> flight = flightRepository.findById((long) flightId);
        System.out.println("========================= Obtained Flight: " + flight.get().getSeatsAvailable());

        if(flight.isPresent()) {
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
        System.out.println("========================= Book Flight: " + flightId);
        Optional<Flight> flight = flightRepository.findById((long) flightId);
        System.out.println("========================= Obtained Flight 1: ");

        if(!flight.isPresent()) {
            throw new FlightNotFoundException("Flight not found");
        }

        if(checkSeatAvailability(flightId) == true) {
            Flight currentFlight = flight.get();
            Reservation booking = new Reservation();

            booking.setConfirmed(true);
            booking.setPassengerId(passenger.getId());
            reservationRepository.save(booking);

            Integer currentSeats = currentFlight.getSeatsAvailable();
            currentFlight.setSeatsAvailable(currentSeats - 1);
            flightRepository.save(currentFlight);

            Ticket currentTicket = new Ticket(
                    currentFlight.getFlightNumber(), currentFlight.getAirline().getName(), currentFlight.getDepartureAirport().getName(), currentFlight.getArrivalAirport().getName(),
                    currentFlight.getDepartureTime(), currentFlight.getDepartureDate(),
                    currentFlight.getArrivalTime(), currentFlight.getArrivalDate(), booking
            );

            ticketRepository.save(currentTicket);

            handleEmail(booking, passenger);
        } else {
            System.out.println("Flight is full");
        }

    }

    @Override
    public void notifyUpcomingFlights() throws ExecutionException, InterruptedException {
        CompletableFuture
                .runAsync(()-> {
            List<Flight> flightList = flightRepository
                    .findByDepartureDate(LocalDate.now());
            Predicate<Ticket> departureDateIsEqual = (ticket) -> {
                return LocalDate.now().isEqual(ticket.getDepartureDate());
            };
            Predicate<Ticket> departureTimeHasTwoHrLeft = (ticket) -> {
                return ticket.getDepartureTime().getHour() - LocalTime.now().getHour() == 2;
            };
            List<String> passengerEmails = flightList.stream()
            .flatMap(flight -> flight.getTickets().stream()).filter(ticket -> departureDateIsEqual.test(ticket) &&
                            departureTimeHasTwoHrLeft.test(ticket))
            .map(ticket -> passengerRepository.findById(ticket.getReservation().getPassengerId()).get().getEmail())
            .collect(Collectors.toList());
            //send
            log.info("Sending emails to {}",passengerEmails);
            //
            //rabbitTemplate.convertAndSend("airline.emails",passengerEmails);
        });
    }

}
