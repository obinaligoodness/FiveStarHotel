package repositoryTest;

import data.models.Room;
import data.models.RoomType;
import data.repositories.RoomInterface;
import data.repositories.RoomInterfaceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RoomInterfaceImplTest {
    Room room;
    RoomInterface roomInterface;
    @BeforeEach
    public void setUp(){
        room = new Room();
        roomInterface = new RoomInterfaceImpl();

    }
    @Test
    public void testThatRoomSaves(){
        room.setCustomerId(1);
        room.setRoomType(RoomType.SINGLE);
        room.setCustomerId(1);
        room.setRoomNumber(1);
        var savedRoom = roomInterface.save(room);
        assertEquals(1,savedRoom.getRoomNumber());
        System.out.println(savedRoom);
    }
    @Test
    public void testThatRoomCanBeFoundByRoomNumber(){
        room.setRoomNumber(2);
        room.setRoomType(RoomType.SINGLE);
        room.setRoomPrice(5000);
        var savedRoom = roomInterface.save(room);
        System.out.println(savedRoom);
        assertEquals(savedRoom,roomInterface.findRoomByRoomNumber(savedRoom.getRoomNumber()));
    }
    @Test
    public void testThatARoomCanBeDeleted(){
        room.setRoomNumber(3);
        room.setRoomType(RoomType.SINGLE);
        room.setRoomPrice(5000);
        var savedRoom = roomInterface.save(room);
        roomInterface.delete(savedRoom);
        assertEquals(null,roomInterface.findRoomByRoomNumber(savedRoom.getRoomNumber()));
    }
}
