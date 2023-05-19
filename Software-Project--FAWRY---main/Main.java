import java.util.Scanner;


public class Main {
    public static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        DataBase dataBase = new DataBase();

        Customer customer = new Customer(null, null, null);
        Admin admin = new Admin(null, null, null);
        //database of all info of the users

        //adding admins to the list of admins authorized
        dataBase.addAdmin("ali", "eslam", "123");
        dataBase.addAdmin("kareem@gmail.com", "kareem", "123");
        dataBase.addAdmin("hassan@gmail.com", "hassan", "000");

        //adding Customers to the list of customers database
        dataBase.addCustomer("ali@gmail.com", "ali", "123");
        dataBase.addCustomer("oka", "oka", "123");
        dataBase.addCustomer("maged@gmail.com", "maged", "000");

        String email;
        String username;
        String password;
        int restart = 1; // 0 no restart
        do {
            int flag = 0;
            int login = 0;
            do {
                // choice to login or register
                String Signtype = printChoice1(); // login or register
                if (Signtype.equals("1")) { // sign in
                    //get input from user
                    String Usertype;
                    System.out.println("    \tChoose \n----------------------- \n 1.Admin \n 2.Customer\n");
                    Usertype = cin.next(); // user typer admin or customer

                    System.out.println("Enter Email:");
                    email = cin.next();
                    System.out.println("Enter Password");
                    password = cin.next();

                    if (Usertype.equals("1")) { // handling sign in for the admin
                        Boolean ok = admin.login(dataBase, email, password);
                        if (ok) {
                            System.out.println("Login Successfully");
                            admin = dataBase.getAdmin(email, password);
                            flag = 1;
                            login = 1;
                        } else
                            System.out.println("No such user registered to the System");
                    } else {
                        // handling sign in for the customer
                        Boolean ok = customer.login(dataBase, email, password);
                        if (ok) {
                            System.out.println("Login Successfully");
                            customer = dataBase.getCustomer(email, password);
                            login = 1;
                        } else
                            System.out.println("No such user registered to the System");
                    }
                } else if (Signtype.equals("2")) {  // Register
                    String Usertype;
                    System.out.println("    \tChoose \n----------------------- \n 1.Admin \n 2.Customer");
                    Usertype = cin.next();
                    System.out.println("Enter Email:");
                    email = cin.next();
                    System.out.println("Enter User Name:");
                    username = cin.next();
                    System.out.println("Enter Password");
                    password = cin.next();
                    if (Usertype.equals("1")) { // handling sign up for the admin
                        Boolean ok = admin.register(dataBase, email, username, password);
                        // check if the user is registered before
                        if (!ok)
                            System.out.println("Already Registered :) ");
                        else {
                            // user not registered before
                            System.out.println("Registered Successfully :)");
                        }
                    } else {
                        // handling registration for the customer
                        Boolean ok = customer.register(dataBase, email, username, password);
                        // check if the user is registered before
                        if (!ok)
                            System.out.println("Already Registered :) ");
                        else {
                            // user not registered before
                            System.out.println("Registered Successfully :)");
                        }
                    }
                }
            } while (login == 0);


            if (flag == 1) {
                int exit = 0;
                do {
                    restart = 1;
                    System.out.println("--------| Hello Admin |-------\n What Do You Want To Do ?\n 1.Add Discount \n 2.View Refunds Requests\n 3.Deal With Refunds \n 4.Sign out\n 5.Exit");
                    String Service = cin.next();  //Admin choosing service to do
                    if (Service.equals("1")) {
                        admin.addDiscount(dataBase);
                    } else if (Service.equals("2")) {
                        admin.viewRefunds(dataBase);
                    } else if (Service.equals("3")) {
                        admin.dealWithRefund(dataBase);
                    } else if (Service.equals("4")) {
                        restart = 0;
                        break;
                    } else if (Service.equals("5"))
                        exit = 1;
                } while (exit == 0);
            } else if (flag == 0) {
                int done = 0;
                Services service = null;
                int repeat = 0;

                do {
                    int dontdo = 0;
                    do {
                        System.out.println("-------| Hello Customer |-------\n 1.Show Services Menu \n 2.Search for Service \n 3.Veiw Discounts \n 4.Add to Wallet \n 5.request refund \n 6.Sign out \n 7.Exit ");
                        String ServiceType = cin.next();
                        // object of the service internet or mobile
                        if (ServiceType.equals("1")) {   // The customer choose from services menu
                            System.out.println("----- |Services Menu| -----\n1.Mobile Recharge Services\n2.Internet Services\n3.Landline Services\n4.Donations");
                            String choice = cin.next(); // choose the recharge service  ( mob  , intern m landline , donations)
                            BigFactory bigFactory = new BigFactory();
                            service = bigFactory.createBig(choice); // create service object
                        } else if (ServiceType.equals("2")) {   // The Customer type the service he needs manually
                            System.out.println("Enter The Service Name You Need : Mobile Recharge Services | Internet Services | Landline Services | Donations ");
                            String choice = cin.next(); // choose the recharge service  ( mob  , intern m landline , donations)
                            BigFactory bigFactory = new BigFactory();
                            service = bigFactory.createBig(choice);
                        } else if (ServiceType.equals("3")) {
                            customer.viewDiscounts(dataBase);
                        } else if (ServiceType.equals("4")) {
                            customer.walletFund();
                        } else if (ServiceType.equals("5")) {
                            customer.refundRequest(dataBase);
                            dontdo = 1;
                        } else if (ServiceType.equals("6")) {
                            repeat = 1;
                            dontdo = 1;
                            done = 1;
                            restart = 0;
                        } else if (ServiceType.equals("7"))
                            System.exit(0);

                        if (service != null) {
                            done = 1;
                        }
                    } while (done == 0);
                    if (dontdo == 0) {
                        Form inputform = new Form();
                        service.setForm(inputform);
                        service.generateForm(); // generating form of the choose payment method
                        FormHandler formHandler = new FormHandler(customer, service, inputform, dataBase);
                        formHandler.proccessInformation(); // procces the transaction , adding transcation to user transcations , doing action
                    }

                } while (repeat == 0);
            }

        } while (restart == 0);

    }


    public static String printChoice1() {
        String Signtype; // holds Signtype of operation in or up
        System.out.println("    \tChoose \n-----------------------\n1- Login\t2- Register\n");
        Signtype = cin.next();
        return Signtype;
    }
}




