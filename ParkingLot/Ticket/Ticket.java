package ParkingLot.Ticket;

import java.time.LocalDateTime;

import ParkingLot.Vehicles.Vehicle;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;

    public Ticket(String ticketId, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        entryTime = LocalDateTime.now();
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }
}
