import javax.xml.crypto.Data;
import java.util.Scanner;

public class Admin implements User {
    String email;
    Scanner cin = new Scanner(System.in);
    String userName;
    String password;

    public Admin(String _email, String _userName, String _password) {
        this.email = _email;
        this.userName = _userName;
        this.password = _password;
    }

    @Override
    public Boolean login(DataBase dataBase, String email, String password) {
        Boolean ok = dataBase.checkAdmin(email, password);
        return ok;
    }

    @Override
    public Boolean register(DataBase dataBase, String email, String userName, String password) {
        Boolean ok = dataBase.checkAdmin(email, password);
        if (!ok) {
            dataBase.addAdmin(email, userName, password);
            return true;
        }
        return false;
    }

    public void addDiscount(DataBase dataBase) {
        System.out.println("what kind of discounts :\n 1.Specific \n 2.OverAll");
        String type = cin.next();
        System.out.println("Enter Amount of dicount divided by 100 (ex:0.75) \n");
        Double amount = cin.nextDouble();
        Discount discount = null;
        if(type.equals("1")){
            discount = new SpecificDiscount(amount);
        }else if(type.equals("2")){
            discount = new SpecificDiscount(amount);
        }
        System.out.println("Discount added successfully");
        dataBase.addDiscount(discount);
    }

    public void viewRefunds(DataBase dataBase) {
        int c = 1;
        for (Refund refund : dataBase.refundRequest) {
            System.out.println(c + ". " + refund.transaction.userName + " request refund of " + refund.transaction.amount + "$");
            c++;
        }
    }

    public void dealWithRefund(DataBase dataBase) {
        System.out.println("Enter Number of refund");
        int c = cin.nextInt();
        for (Refund refund : dataBase.refundRequest) {
            c--;
            if (c == 0) {
                System.out.println("1.Accept \n 2.Reject");
                String refundNewState = cin.next();
                if (refundNewState == "1") {
                    refund.state = "Accepeted";
                    refund.notifyAllObservers();
                } else if (refundNewState == "2") {
                    refund.state = "Rejected";
                    refund.notifyAllObservers();
                }
                dataBase.refundRequest.remove(refund);
                break;
            }
        }
    }


}
