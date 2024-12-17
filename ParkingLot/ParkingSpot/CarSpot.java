package ParkingLot.ParkingSpot;

import ParkingLot.Vehicles.VehicleType;

public class CarSpot extends ParkingSpot{
    CarSpot(String id) {
        super(id);
    }

    @Override
    public VehicleType getSupportedVehicleType() {
        return VehicleType.CAR;
    }
    
}
