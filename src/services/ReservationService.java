package services;

import data.models.Reservation;
import dto.CustomerResponse;
import dto.ReservationRequest;
import dto.ReservationResponse;

import java.util.ArrayList;

public interface ReservationService {
    public ReservationResponse saveReservedRooms(ReservationRequest reservationRequest);
    public ReservationResponse customersReservations(CustomerResponse customerResponse);
    public ArrayList<Reservation> findAllReservations();
}

