package services;

import data.models.Room;
import data.models.RoomType;
import data.repositories.RoomInterface;
import data.repositories.RoomInterfaceImpl;
import dto.ReservationRequest;
import dto.ReservationResponse;
import utils.Mapper;

import java.util.List;


public class RoomServiceImpl implements RoomService{
    RoomInterface roomInterface = new RoomInterfaceImpl();
    ReservationService reservationService = new ReservationServiceImpl();

    public void createRoom(){
        for (int index = 1; index <= 10; index++) {
                Room room = new Room();
            if (index <= 5){
                room.setRoomNumber(index);
                room.setRoomPrice(50_000);
                room.setRoomType(RoomType.SINGLE);
            }
            if (index > 5){
                room.setRoomNumber(index);
                room.setRoomPrice(100_000);
                room.setRoomType(RoomType.DOUBLE);
            }
            roomInterface.save(room);
        }

    }
    public ReservationResponse reserveRoom (ReservationRequest reservationRequest){
        var room =  roomInterface.findRoomByRoomNumber(reservationRequest.getRoomNumber());
        if (room!=null){
        if (!room.isBooked()){

            room.setCheckInDate(reservationRequest.getCheckInDate());
            room.setCheckOutDate(reservationRequest.getCheckOutDate());
            room.setCustomerId(reservationRequest.getCustomerId());

            room.setCustomerFirstName(reservationRequest.getCustomerFirstName());
            room.setCustomerLastName(reservationRequest.getCustomerLastName());
            room.setCustomerEmail(reservationRequest.getCustomerEmail());

            room.setBooked(true);

        var savedRoom = roomInterface.save(room);
//        var roomReceipt = Mapper.map(savedRoom);

        ReservationRequest reservationRequest1 = new ReservationRequest();
        ReservationRequest reservationRequest2 = Mapper.map(savedRoom,reservationRequest1 );

        var savedReservation = reservationService.saveReservedRooms(reservationRequest2);

        return savedReservation;
        }
        }
        return null;
    }

    @Override
    public Room[] findAllRooms() {
        return roomInterface.getAllRooms();
    }

}
