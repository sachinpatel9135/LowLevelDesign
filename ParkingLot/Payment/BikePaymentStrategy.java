package ParkingLot.Payment;

public class BikePaymentStrategy implements PaymentStrategy{

    @Override
    public double calculateFee(long hours) {
        return hours*5;
    }
    
}
