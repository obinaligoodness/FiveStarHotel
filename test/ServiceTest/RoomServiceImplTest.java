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

public class RoomServiceImplTest {
    RoomService roomService;
    RegisterRequest registerRequest;
    CustomerService customerService;
    @BeforeEach
    public void setUp(){
        roomService = new RoomServiceImpl();
        registerRequest = new RegisterRequest();
        customerService = new CustomerServiceImpl();
    }
    @Test
    public void testThatCustomerCanReserveARoom(){
        registerRequest.setFirstName("goodness");
        registerRequest.setLastName("obinali");
        registerRequest.setEmail("obiali@goodnessshhdfegb");
        var registeredCustomer = customerService.registerCustomer(registerRequest);
        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setCustomerId(registeredCustomer.getCustomerId());
        reservationRequest.setRoomType(RoomType.SINGLE);
        reservationRequest.setRoomNumber(1);
        System.out.println(roomService.reserveRoom(reservationRequest));
    }
}
