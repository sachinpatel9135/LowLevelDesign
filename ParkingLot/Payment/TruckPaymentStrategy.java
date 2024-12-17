package ParkingLot.Payment;

public class TruckPaymentStrategy implements PaymentStrategy{

    @Override
    public double calculateFee(long hours) {
        return hours*20;
    }
    
}
