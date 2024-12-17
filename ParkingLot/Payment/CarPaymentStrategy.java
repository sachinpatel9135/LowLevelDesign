package ParkingLot.Payment;

public class CarPaymentStrategy implements PaymentStrategy {

    @Override
    public double calculateFee(long hours) {
        return 10*hours;
    }
}
