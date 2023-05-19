
public class CashPayment implements Payment{

    public Transaction pay(Customer customer, double amount) {
        Transaction transaction = new Transaction();
        System.out.println("Transaction Done Successfully By Cash Payment");
        transaction.amount = amount;
        transaction.userName = customer.userName;
        return transaction;
    }
}
