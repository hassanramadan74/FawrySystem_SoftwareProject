import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public abstract class LandlineService implements Services{
    public double Amount=0;
    Form form;
    Scanner cin = new Scanner(System.in);

    public LandlineService(){
        Random r = new Random();
        Amount =  r.nextInt(400) + 1;
    }
    public void setForm(Form form){
        this.form = form;
    }
    public void generateForm() {
        String landlineNumber;
        String amountToPay;
        String zipCode;

        System.out.println("Enter your Zip Code : ");
        zipCode = cin.next();

        System.out.println("Enter your Landline Number :");
        landlineNumber = cin.next();

        System.out.println("Enter Amount to Pay :");
        amountToPay = cin.next();
        form.attr.put("Zip Code" , zipCode);
        form.attr.put("Landline number" , landlineNumber);
        form.attr.put("Amount" , amountToPay);
        viewServiceAmount();
        form.paymentMethod();
    }
    public void viewServiceAmount(){
        System.out.println("Service Amount Required is "+Amount);
    }

    public void setAmount(Double amount){
        this.Amount=amount;
    }
    public Double getAmount(){
        return Amount;
    }
}
