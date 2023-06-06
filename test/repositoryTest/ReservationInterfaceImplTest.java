package repositoryTest;

import data.models.Customer;
import data.models.Reservation;
import data.models.RoomType;
import data.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationInterfaceImplTest {
    Reservation reservation;
    ReservationInterface reservationInterface;
    @BeforeEach
    public void setUp(){
        reservation = new Reservation();
        reservationInterface = new ReservationInterfaceImpl();
    }

    @Test
    public void testThatReservationSaves(){
        reservation.setRoomNumber(2);
        reservation.setRoomType(RoomType.SINGLE);
        reservation.setRoomPrice(5000);
        var savedReservation = reservationInterface.saveReservations(reservation);
        assertEquals(savedReservation,reservationInterface.saveReservations(reservation));
    }
    @Test
    public void testThatReservationCanBeFoundByRoomNumber(){
        reservation.setRoomNumber(2);
        reservation.setRoomType(RoomType.SINGLE);
        reservation.setRoomPrice(5000);
        var savedReservation = reservationInterface.saveReservations(reservation);
        var foundReservation = reservationInterface.findReservationsByRoomNumber(savedReservation.getRoomNumber());
        assertEquals(foundReservation,reservationInterface.findReservationsByRoomNumber(savedReservation.getRoomNumber()));
    }
    @Test
    public void testThatAReservationCanBeDeleted(){
        reservation.setRoomNumber(2);
        reservation.setRoomType(RoomType.SINGLE);
        reservation.setRoomPrice(5000);
        var savedReservation = reservationInterface.saveReservations(reservation);
        var deletedReservation = reservationInterface.DeleteReservations(savedReservation.getRoomNumber());
        assertEquals(null,reservationInterface.findReservationsByRoomNumber(savedReservation.getRoomNumber()));
    }

}
