package ServiceTest;

import data.models.Room;
import data.models.RoomType;
import dto.RegisterRequest;
import dto.ReservationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.CustomerService;
import services.CustomerServiceImpl;
import services.RoomService;
import services.RoomServiceImpl;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomServiceImplTest {
    RoomService roomService;
    RegisterRequest registerRequest;
    CustomerService customerService;
    @BeforeEach
    public void setUp(){
        roomService = new RoomServiceImpl();
        registerRequest = new RegisterRequest();
        customerService = new CustomerServiceImpl();
        roomService.createRoom();
    }
    @Test
    public void testThatCustomerCanReserveARoom(){
        registerRequest.setFirstName("goodness");
        registerRequest.setLastName("obinali");
        registerRequest.setEmail("obiali@goodnessshhdfegb");
        var registeredCustomer = customerService.registerCustomer(registerRequest);
        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setCustomerId(registeredCustomer.getCustomerId());
        reservationRequest.setCustomerFirstName(registeredCustomer.getFirstName());
        reservationRequest.setCustomerLastName(registeredCustomer.getLastName());
        reservationRequest.setRoomNumber(5);
        reservationRequest.setCustomerEmail(registeredCustomer.getEmail());
        var reservedRoom = roomService.reserveRoom(reservationRequest);
        assertEquals(registeredCustomer.getFirstName(),reservedRoom.getCustomerFirstName());

    }
}
