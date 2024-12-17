package ParkingLot.ParkingSpot;

import ParkingLot.Vehicles.VehicleType;

public class BikeSpot extends ParkingSpot{
    BikeSpot(String id) {
        super(id);
    }

    @Override
    public VehicleType getSupportedVehicleType() {
        return VehicleType.BIKE;
    }
}
