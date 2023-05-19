import java.util.HashMap;
import java.util.Random;
import java.util.Random;
import java.util.Scanner;

public class DonationService implements Services {
    public double Amount = 0;
    Form form;
    Scanner cin = new Scanner(System.in);

    public DonationService() {
        Random r = new Random();
        Amount = r.nextInt(150) + 1;
    }
    public void setForm(Form form){
        this.form = form;
    }

    public void setAmount(Double amount){
        this.Amount=amount;
    }
    public Double getAmount(){
        return Amount;
    }

    public void display() {
        System.out.println("Donation Service Running");
    }

    @Override
    public void pay() {
        System.out.println("Donation Service Pay function");
    }

    @Override
    public void generateForm() {
        String org;
        String amountToPay;
        System.out.println("Enter the Organization :");
        org = cin.next();
        System.out.println("Amount to Donate :");
        amountToPay = cin.next();
        form.attr.put("Organization",org);
        form.attr.put("Amount" , amountToPay);
        form.paymentMethod();
    }
    public void viewServiceAmount(){
        System.out.println("Service Amount Required is "+Amount);
    }

}

