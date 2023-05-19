public class SpecificDiscount implements Discount {
    Double discountAmount = 0.5;
    String discountName = "Specific Discount";
    public SpecificDiscount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public void applyDiscount(Services service) {
        Double amount = service.getAmount();
        if (service instanceof MobileRechargeService) {
            System.out.println("Specific discount added");
            amount *= discountAmount;
        } else {
            System.out.println("Not applicable");
        }
        service.setAmount(amount);
    }
    @Override
    public String getDiscountName() {
        return discountName;
    }

    @Override
    public Double getDiscountAmount() {
        return discountAmount;
    }
}
