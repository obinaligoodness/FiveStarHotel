package data.repositories;

import data.models.Reservation;

import java.util.ArrayList;

public class ReservationInterfaceImpl implements ReservationInterface{
    ArrayList  <Reservation>reservations = new ArrayList<>();
    @Override
    public Reservation saveReservations(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Reservation findReservationsByRoomNumber(int roomNumber) {
        for(Reservation reservation:reservations){
            if (reservation.getRoomNumber()==roomNumber) return reservation;
        }
        return null;
    }

    @Override
    public ArrayList<Reservation> findAllReservations() {
        return reservations;
    }

    @Override
    public Reservation DeleteReservations(int roomNumber) {
        for (Reservation reservation:reservations){
            if (reservation.getRoomNumber()==roomNumber) {
                reservations.remove(reservation);
                return reservation;
            }
        }
        return null;
    }
    @Override
    public Reservation findReservationsByCustomerId(int customerId){
        for (Reservation reservation:reservations){
            if (reservation.getCustomerId()==customerId) return reservation;
        }
        return null;
    }
}
