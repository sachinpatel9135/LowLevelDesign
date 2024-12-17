package ParkingLot.ParkingSpot;

import ParkingLot.Vehicles.VehicleType;

abstract public class ParkingSpot {
    private String id;
    private boolean isOccupied;

    ParkingSpot(String id) {
        this.id = id;
        this.isOccupied = false;
    }

    public void occupySpot() {
        isOccupied = true;
    }

    public void vacateSpot() {
        isOccupied = false;
    }
    
    public boolean isAvailable() {
        return !isOccupied;
    }

    public String getId() {
        return id;
    }

    public abstract VehicleType getSupportedVehicleType();
}