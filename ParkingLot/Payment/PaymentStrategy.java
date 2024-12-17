package ParkingLot.Payment;

public interface PaymentStrategy {
    double calculateFee(long hours);
}