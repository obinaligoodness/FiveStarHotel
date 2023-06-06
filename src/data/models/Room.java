package data.models;

import java.time.LocalDate;

public class Room {
    private int roomId;
    private RoomType roomType;
    private int roomPrice;
    private int roomNumber;
    private int customerId;
    private boolean isBooked;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("roomType=").append(roomType);
        sb.append(", roomPrice=").append(roomPrice);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", customerId=").append(customerId);
        sb.append(", checkInDate=").append(checkInDate);
        sb.append(", checkOutDate=").append(checkOutDate);
        sb.append(", customerFirstName='").append(customerFirstName).append('\'');
        sb.append(", customerLastName='").append(customerLastName).append('\'');
        sb.append(", customerEmail='").append(customerEmail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
