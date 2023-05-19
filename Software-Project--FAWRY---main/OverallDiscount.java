public class OverallDiscount implements Discount {

    Double discountAmount = 0.75;
    String discountName = "Overall Discount";

    public OverallDiscount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public void applyDiscount(Services service) {
        Double amount = service.getAmount();
        System.out.println("Specific discount added");
        amount *= discountAmount;
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
