package utils;
import data.models.Customer;
import data.models.Reservation;
import data.models.Room;
import data.models.RoomType;
import data.repositories.CustomerInterface;
import data.repositories.CustomerInterfaceImpl;
import dto.*;

public class Mapper {
    public static Customer map(RegisterRequest registerRequest){
        Customer customer = new Customer();
        customer.setLastName(registerRequest.getLastName());
        customer.setFirstName(registerRequest.getFirstName());
        customer.setEmail(registerRequest.getEmail());
        return customer;
    }
    public static RegisterResponse map(Customer customer){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setFirstName(customer.getFirstName());
        registerResponse.setLastName(customer.getLastName());
        registerResponse.setEmail(customer.getEmail());
        registerResponse.setCustomerId(customer.getId());
        return registerResponse;
    }

    public static ProfileResponse map(RegisterResponse registerResponse){
        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setFirstName(registerResponse.getFirstName());
        profileResponse.setLastName(registerResponse.getLastName());
        profileResponse.setEmail(registerResponse.getEmail());
        return profileResponse;
    }
    public static Reservation map(ReservationRequest reservationRequest){
        Reservation reservation = new Reservation();
        reservation.setRoomType(reservationRequest.getRoomType());
        reservation.setCustomerId(reservationRequest.getCustomerId());
        reservation.setRoomNumber(reservationRequest.getRoomNumber());
        reservation.setCheckInDate(reservationRequest.getCheckInDate());
        reservation.setCheckOutDate(reservationRequest.getCheckOutDate());
        reservation.setCustomerFirstName(reservationRequest.getCustomerFirstName());
        reservation.setCustomerLastName(reservationRequest.getCustomerLastName());
        reservation.setCustomerEmail(reservationRequest.getCustomerEmail());
        if (reservationRequest.getRoomType()== RoomType.SINGLE){
            reservation.setRoomPrice(50000);}
        else if (reservationRequest.getRoomType()==RoomType.DOUBLE) {
            reservation.setRoomPrice(100000);
        }
        return reservation;
    }
    public static ReservationResponse map(Reservation reservation){
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setCustomerFirstName(reservation.getCustomerFirstName());
        reservationResponse.setCustomerLastName(reservation.getCustomerLastName());
        reservationResponse.setCustomerEmail(reservation.getCustomerEmail());
        reservationResponse.setRoomPrice(reservation.getRoomPrice());
        reservationResponse.setCheckInDate(reservation.getCheckInDate());
        reservationResponse.setCheckOutDate(reservation.getCheckOutDate());
        reservationResponse.setRoomType(reservation.getRoomType());
        reservationResponse.setRoomNumber(reservation.getRoomNumber());
        return reservationResponse;
    }
    public static ReservationResponse map(Room room){
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setRoomNumber(room.getRoomNumber());
        reservationResponse.setRoomType(room.getRoomType());
        reservationResponse.setRoomPrice(room.getRoomPrice());
        CustomerInterface customerInterface = new CustomerInterfaceImpl();
        var foundCustomer = customerInterface.findCustomerById(room.getCustomerId());
        reservationResponse.setCustomerFirstName(room.getCustomerFirstName());
        reservationResponse.setCustomerLastName(room.getCustomerLastName());
        reservationResponse.setCustomerEmail(room.getCustomerEmail());
        reservationResponse.setCheckInDate(room.getCheckInDate());
        reservationResponse.setCheckOutDate(room.getCheckOutDate());
        return reservationResponse;
    }
    public static Customer map(CustomerResponse customerResponse){
        Customer customer = new Customer();
        customer.setFirstName(customerResponse.getFirstName());
        customer.setLastName(customerResponse.getLastName());
        customer.setEmail(customerResponse.getEmail());
        customer.setId(customerResponse.getId());
        return customer;
    }

    public static ReservationRequest map(Room savedRoom, ReservationRequest reservationRequest1) {
        reservationRequest1.setRoomNumber(savedRoom.getRoomNumber());
        reservationRequest1.setRoomPrice(savedRoom.getRoomPrice());
        reservationRequest1.setRoomType(savedRoom.getRoomType());
        reservationRequest1.setCustomerId(savedRoom.getCustomerId());
        reservationRequest1.setCheckInDate(savedRoom.getCheckInDate());
        reservationRequest1.setCheckOutDate(savedRoom.getCheckOutDate());
        reservationRequest1.setCustomerFirstName(savedRoom.getCustomerFirstName());
        reservationRequest1.setCustomerLastName(savedRoom.getCustomerLastName());
        reservationRequest1.setCustomerEmail(savedRoom.getCustomerEmail());

        return  reservationRequest1;
    }
}
