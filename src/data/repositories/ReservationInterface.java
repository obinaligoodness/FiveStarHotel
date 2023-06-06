package data.repositories;

import data.models.Reservation;

import java.util.ArrayList;

public interface ReservationInterface {

    Reservation saveReservations(Reservation reservation);
    Reservation findReservationsByRoomNumber(int roomNumber);
    ArrayList<Reservation> findAllReservations();
    Reservation DeleteReservations(int roomNumber);

    Reservation findReservationsByCustomerId(int customerId);
}
