package services;


import data.models.Room;
import dto.ReservationRequest;
import dto.ReservationResponse;
import java.util.List;

public interface RoomService {
    public ReservationResponse reserveRoom (ReservationRequest reservationRequest);
    Room[] findAllRooms ();
    public void createRoom();
}
