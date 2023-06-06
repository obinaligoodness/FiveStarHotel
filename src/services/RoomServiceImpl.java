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
        boolean roomsAlreadyExist = roomInterface.getAllRooms() != null;
        if (!roomsAlreadyExist){
            int price;
            RoomType type;
            for (int i = 0; i < 6; i++) {
//                price = i >= 0 && i <= 4 ? 50000: 100000;
//                type = i >= 0 && i <= 4 ? RoomType.SINGLE: RoomType.DOUBLE;
                Room room = new Room();
                room.setRoomNumber(i);
//                room.setRoomPrice(price);
//                room.setRoomType(type);
                roomInterface.save(room);
            }
        }
    }
    public ReservationResponse reserveRoom (ReservationRequest reservationRequest){
        Room room = new Room();
        room.setRoomType(reservationRequest.getRoomType());
        room.setCustomerId(reservationRequest.getCustomerId());
        room.setRoomNumber(reservationRequest.getRoomNumber());
        room.setCheckInDate(reservationRequest.getCheckInDate());
        room.setCheckOutDate(reservationRequest.getCheckOutDate());
        if (reservationRequest.getRoomType()== RoomType.SINGLE){
            room.setRoomPrice(50000);}
        else if (reservationRequest.getRoomType()==RoomType.DOUBLE) {
            room.setRoomPrice(100000);
        }
        room.setCustomerFirstName(reservationRequest.getCustomerFirstName());
        room.setCustomerLastName(reservationRequest.getCustomerLastName());
        room.setCustomerEmail(reservationRequest.getCustomerEmail());
        var foundRoom =  roomInterface.findRoomByRoomNumber(room.getRoomNumber());
        System.out.println(foundRoom);
        if (foundRoom!=null){
        if (!foundRoom.isBooked()){
            room.setBooked(true);
        var savedRoom = roomInterface.save(room);
        var roomReceipt = Mapper.map(savedRoom);
        ReservationRequest reservationRequest1 = new ReservationRequest();
        reservationRequest1.setRoomNumber(savedRoom.getRoomNumber());
        reservationRequest1.setRoomPrice(savedRoom.getRoomPrice());
        reservationRequest1.setRoomType(savedRoom.getRoomType());
        reservationRequest1.setCustomerId(savedRoom.getCustomerId());
        reservationRequest1.setCheckInDate(savedRoom.getCheckInDate());
        reservationRequest1.setCheckOutDate(savedRoom.getCheckOutDate());
        reservationRequest1.setCustomerFirstName(savedRoom.getCustomerFirstName());
        reservationRequest1.setCustomerLastName(savedRoom.getCustomerLastName());
        reservationRequest1.setCustomerEmail(savedRoom.getCustomerEmail());
        var savedReservation = reservationService.saveReservedRooms(reservationRequest1);
        return roomReceipt;}}
        return null;
    }

    @Override
    public Room[] findAllRooms() {
        return roomInterface.getAllRooms();
    }

}
