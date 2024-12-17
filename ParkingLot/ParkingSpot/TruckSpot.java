package ParkingLot.ParkingSpot;

import ParkingLot.Vehicles.VehicleType;

public class TruckSpot extends ParkingSpot{
    TruckSpot(String id) {
        super(id);
    }

    @Override
    public VehicleType getSupportedVehicleType() {
        return VehicleType.TRUCK;
    }
    
}
