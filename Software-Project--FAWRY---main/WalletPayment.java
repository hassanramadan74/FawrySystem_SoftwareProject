public class WalletPayment implements Payment {

    @Override
    public Transaction pay(Customer customer, double amount) {
        Transaction transaction = new Transaction();
        System.out.println("Transaction Done Successfully by Wallet Payment");
        transaction.amount = amount;
        transaction.userName = customer.userName;
        customer.wallet -= amount;
        System.out.println("Your Wallet Amount is " + customer.wallet);
        return transaction;
    }
}
