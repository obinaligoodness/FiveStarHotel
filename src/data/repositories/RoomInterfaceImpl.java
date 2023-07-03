package data.repositories;
import data.models.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomInterfaceImpl implements RoomInterface{
    private static Room[] hotel = new Room[11];
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
//        Room temp = hotel[room.getRoomNumber()-1];

        hotel[room.getRoomNumber()] = room;
//        System.out.println(Arrays.toString( hotel));
        return hotel[room.getRoomNumber()];
    }

//    public Room save2(Room room){
////        Room temp = hotel[room.getRoomNumber()-1];
//        hotel[room.getRoomNumber()] = null;
//        hotel[room.getRoomNumber()] = room;
////        System.out.println(Arrays.toString( hotel));
//        return hotel[room.getRoomNumber()];
//    }

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

