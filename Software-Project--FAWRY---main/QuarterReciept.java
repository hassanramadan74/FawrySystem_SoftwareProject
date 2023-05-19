public class QuarterReciept extends LandlineService{

    public double createReciept() {
        System.out.println("your monthly receipt is "+Amount*4);
        return Amount*4;
    }

    @Override
    public void display() {
        System.out.println("QuarterReciept landline Recharge Running");
    }

    @Override
    public void pay() {
        System.out.println("QuarterReciept landline Recharge Running pay function");
    }
}
