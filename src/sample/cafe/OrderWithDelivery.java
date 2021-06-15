package sample.cafe;

import java.time.LocalDate;

public class OrderWithDelivery {

    private int idOrderWithDelivery;
    private String address;
    private int phoneNumber;
    private LocalDate date;

    public OrderWithDelivery(int idOrderWithDelivery, String address, int phoneNumber, LocalDate date) {
        this.idOrderWithDelivery = idOrderWithDelivery;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    public int getIdOrderWithDelivery() {
        return idOrderWithDelivery;
    }

    public void setIdOrderWithDelivery(int idOrderWithDelivery) {
        this.idOrderWithDelivery = idOrderWithDelivery;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
