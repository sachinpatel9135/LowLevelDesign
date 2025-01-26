Coupon System LLD

- Coupon can give off in percentage or in actual amount of money
- Coupon can be applicable or not
- We should be able to select coupon if it's applicable and overall payment money should be reduced

Entities - 
Actor - User, System

Coupon - Based on percentage, amountOfMoney
Coupon - code, detail, 
    -> PercentageCoupon - minimumOrderLimit, pecentage 
    -> AmountCoupon - minumOrderLimit, amountOff
    -> ICCIBankCreditCard - minumumOrderLimit, percentage, paymentCondition


PayementModes - UPI, CreditCard, Cash

CouponService - Create, delete, update Coupon, List<Coupons> getCoupon(orderCost, PaymentMode),     updatedCost -> applyCoupon(orderCost, Coupon)