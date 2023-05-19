import java.util.Random;
import java.util.Scanner;

public abstract class InternetService implements Services {
    double Amount;
    Form form;
    Scanner cin = new Scanner(System.in);

    public InternetService() {
        Random r = new Random();
        Amount = r.nextInt(700) + 1;
    }
    public void setForm(Form form){
        this.form = form;
    }

    @Override
    public void generateForm() {
        String landlineNumber;
        String amountToPay;
        String Name;

        System.out.println("Enter your Name :");
        Name = cin.next();

        System.out.println("Enter your Internet Number :");
        landlineNumber = cin.next();
        System.out.println("Enter Amount to Pay :");
        amountToPay = cin.next();
        form.attr.put("Name", Name);
        form.attr.put("Landline number", landlineNumber);
        form.attr.put("Amount", amountToPay);
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
