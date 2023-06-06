package services;

import data.models.Reservation;
import data.repositories.ReservationInterface;
import data.repositories.ReservationInterfaceImpl;
import dto.CustomerResponse;
import dto.ReservationRequest;
import dto.ReservationResponse;
import utils.Mapper;

import java.util.ArrayList;

public class ReservationServiceImpl implements ReservationService{
    static ReservationInterface reservationInterface = new ReservationInterfaceImpl();
    @Override
    public ReservationResponse saveReservedRooms(ReservationRequest reservationRequest) {
        var mappedRoom = Mapper.map(reservationRequest);
        var reservedRoom = reservationInterface.saveReservations(mappedRoom);
        return Mapper.map(reservedRoom);
    }
    public ReservationResponse customersReservations(CustomerResponse customerResponse){
        var mappedCustomer = Mapper.map(customerResponse);
        var customerId = mappedCustomer.getId();
        var foundReservation = reservationInterface.findReservationsByCustomerId(customerId);
        return Mapper.map(foundReservation);
    }

    public ArrayList<Reservation> findAllReservations(){
        return reservationInterface.findAllReservations();
    }
}