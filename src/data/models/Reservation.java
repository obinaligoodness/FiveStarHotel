package data.models;

import java.time.LocalDate;

public class Reservation {
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private RoomType roomType;
    private int roomNumber;
    private int roomPrice;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reservation{");
        sb.append("customerFirstName='").append(customerFirstName).append('\'');
        sb.append(", customerLastName='").append(customerLastName).append('\'');
        sb.append(", customerEmail='").append(customerEmail).append('\'');
        sb.append(", roomType=").append(roomType);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", roomPrice=").append(roomPrice);
        sb.append(", checkInDate=").append(checkInDate);
        sb.append(", checkOutDate=").append(checkOutDate);
        sb.append('}');
        return sb.toString();
    }
}
