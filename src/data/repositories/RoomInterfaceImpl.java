package data.repositories;
import data.models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomInterfaceImpl implements RoomInterface{
    private static Room[] hotel = new Room[6];
//    ArrayList<Room> roomList = new ArrayList<Room>();

    @Override
//    public Room save(Room room) {
//        for (int i = 0; i < hotel.length; i++) {
//            if (room.getRoomNumber()==i){
//                if (hotel[i].getCustomerId()==0){
//                hotel[i].setCustomerId(room.getCustomerId());
//                return hotel[i];
//                }
//            }
//        }
//        return null;
//    }
    public Room save(Room room){
        Room temp = hotel[room.getRoomNumber()];
        hotel[room.getRoomNumber()] = room;
        return hotel[room.getRoomNumber()];
    }

    @Override
    public Room findRoomByRoomNumber(int roomNumber) {
        return hotel[roomNumber];
//
//        for (Room room : hotel)
//            if (room.getRoomNumber()==roomNumber)
//                return room;
//
////        return hotel[roomNumber];
//        return null;
    }

    @Override
    public Room[] getAllRooms() {
        return hotel;
    }

    @Override
    public boolean delete(Room room) {
        hotel[room.getRoomNumber()] = null;
        return true;
    }}

