package CouponSystem;

public abstract class Coupon {
    private String code;
    private String details;
    private Double minOrderLimit;
    private PaymentModeStrategy paymentModeStrategy;

    public Coupon(PaymentModeStrategy paymentModeStrategy) {
        this.paymentModeStrategy = paymentModeStrategy;
    }
}
