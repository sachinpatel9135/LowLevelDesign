package ParkingLot;

import ParkingLot.Vehicles.Vehicle;
import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.Vehicles.Car;

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getParkingLotInstance();
        lot.addFloor(new ParkingFloor("F1", 2, 2, 1));

        Vehicle car = new Car("CAR123");
        ParkingSpot spot = lot.parkVehicle(car);
        if (spot != null) {
            System.out.println("Car parked at spot: " + spot);
        } else {
            System.out.println("No spot available for the car.");
        }
    }
}
