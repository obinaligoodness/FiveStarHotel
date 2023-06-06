package ServiceTest;

import data.models.RoomType;
import dto.CustomerResponse;
import dto.RegisterRequest;
import dto.ReservationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationServiceImplTest {
    ReservationService reservationService;
    RegisterRequest registerRequest;
    CustomerService customerService;
    RoomService roomService;
    @BeforeEach
    public void setUp(){
        reservationService = new ReservationServiceImpl();
        registerRequest = new RegisterRequest();
        customerService = new CustomerServiceImpl();
        roomService = new RoomServiceImpl();
    }
    @Test
    public void testThatAReservedRoomCanBeSavedInReservations() {
        roomService.createRoom();
        registerRequest.setFirstName("goodness");
        registerRequest.setLastName("obinali");
        registerRequest.setEmail("obiali@goodnessshhdfegb");
        var registeredCustomer = customerService.registerCustomer(registerRequest);


        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setCustomerId(registeredCustomer.getCustomerId());
        reservationRequest.setRoomType(RoomType.SINGLE);
        reservationRequest.setRoomNumber(1);
        reservationRequest.setCustomerFirstName(registeredCustomer.getFirstName());
        reservationRequest.setCustomerLastName(registeredCustomer.getLastName());
        reservationRequest.setCustomerEmail(registeredCustomer.getEmail());
        var reservedRoom = roomService.reserveRoom(reservationRequest);






        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setFirstName("victor");
        registerRequest1.setLastName("obinali");
        registerRequest1.setEmail("victorobinali@gmail.com");
        var secondRegisteredCustomer = customerService.registerCustomer(registerRequest1);


        ReservationRequest reservationRequest1 = new ReservationRequest();
        reservationRequest1.setCustomerId(secondRegisteredCustomer.getCustomerId());
        reservationRequest1.setRoomNumber(1);
        reservationRequest1.setRoomType(RoomType.SINGLE);
        reservationRequest1.setCustomerFirstName(secondRegisteredCustomer.getFirstName());
        reservationRequest1.setCustomerLastName(secondRegisteredCustomer.getLastName());
        reservationRequest1.setCustomerEmail(secondRegisteredCustomer.getEmail());
        var reservedRoom1 = roomService.reserveRoom(reservationRequest1);

        System.out.println("***"+roomService.findAllRooms());


//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setId(secondRegisteredCustomer.getCustomerId());
//        CustomerResponse customerResponse1 = new CustomerResponse();
//
//        System.out.println(reservationService.customersReservations(customerResponse));
        System.out.println(reservationService.findAllReservations());
    }
    @Test
    public void test(){


    }

}