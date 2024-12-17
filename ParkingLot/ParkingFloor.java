package ParkingLot;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.ParkingSpot.*;
import ParkingLot.Vehicles.VehicleType;

public class ParkingFloor {
    String floorId;
    private List<ParkingSpot> spots;

    public ParkingFloor(String floorId, int carSpots, int bikeSpots, int truckSpots) {
        this.floorId = floorId;
        spots = new ArrayList<>();
        for(int i=0; i<carSpots; i++) spots.add(ParkingSpotFactory.createParkingSpot("C"+i, VehicleType.CAR));
        for(int i=0; i<bikeSpots; i++) spots.add(ParkingSpotFactory.createParkingSpot("B"+i, VehicleType.BIKE));
        for(int i=0; i<truckSpots; i++) spots.add(ParkingSpotFactory.createParkingSpot("T"+i, VehicleType.TRUCK));
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for(ParkingSpot spot: spots) {
            if(spot.getSupportedVehicleType() == vehicleType && spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }
}
