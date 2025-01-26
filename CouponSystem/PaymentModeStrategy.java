package CouponSystem;

public class PaymentModeStrategy implements IsApplicableStrategy{
    private PaymentMode paymentMode;
    public boolean isApplicable(PaymentMode paymentMode) {
        return true;
    }
}
