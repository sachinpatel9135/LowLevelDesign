package ParkingLot.ParkingSpot;

import ParkingLot.Vehicles.VehicleType;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpot(String id, VehicleType type) {
        switch (type) {
            case BIKE:
                return new BikeSpot(id);
            case CAR:
                return new CarSpot(id);
            case TRUCK:
                return new TruckSpot(id);
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
