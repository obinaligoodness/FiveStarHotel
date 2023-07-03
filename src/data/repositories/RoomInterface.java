package data.repositories;

import data.models.Room;

import java.util.List;

public interface RoomInterface {
    Room save(Room room);
//    Room save2(Room room);
    Room findRoomByRoomNumber(int roomId);
    Room[] getAllRooms();
    boolean delete(Room room);
}
