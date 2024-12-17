package ParkingLot;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.Vehicles.*;

public class ParkingLot {
    private static ParkingLot instance;
    List<ParkingFloor> floors;

    private ParkingLot() {
        floors = new ArrayList<>();
    }

    public static synchronized ParkingLot getParkingLotInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle.getVehicleType());
            if (spot != null) {
                spot.occupySpot();
                return spot;
            }
        }
        return null; // No available spot
    }
}
