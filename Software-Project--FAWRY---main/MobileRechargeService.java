import java.util.*;

public abstract class MobileRechargeService implements Services {
    double Amount;
    Form form;
    Scanner cin = new Scanner(System.in);



    public MobileRechargeService() {
        Random r = new Random();
        Amount = r.nextInt(1000) + 1;
    }
    public void setForm(Form form){

        this.form = form;
    }

    @Override
    public void generateForm() {
        String MobileService;
        String amountToPay;
        System.out.println("Enter your Mobile Number :");
//        viewServiceAmount();
        MobileService = cin.next();
        System.out.println("Enter Amount to Pay :");
        amountToPay = cin.next();
        form.attr.put("Mobile Number" , MobileService);
        form.attr.put("Amount" , amountToPay);
        form.paymentMethod();
    }

    public void setAmount(Double amount){
        this.Amount=amount;
    }
    public Double getAmount(){
        return Amount;
    }
    public void viewServiceAmount(){
        System.out.println("Service Amount Required is "+Amount);
    }

}
