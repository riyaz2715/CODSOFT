import java.util.*;
class bankaccount{
    private double balance;
    public bankaccount(double initialbalance) {
        balance = initialbalance;
    }
     public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; // Insufficient balance
        }
        balance -= amount;
        return true;
    }
    public double getbalance() {
        return balance;
    }
}

public class atminterface
{
    private bankaccount account;
    public atminterface(bankaccount useraccount)
    {
        account = useraccount;
    }
    public void displaymenu()
    {
        System.out.println("\n ATM MENU");
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void performaction(int choice ,Scanner sc)
    {
        switch(choice)
        {
            case 1:
                checkbalance();
                break;
            case 2:
                deposit(sc);
                break;
            case 3:
                withdraw(sc);
                break;
            case 4:
                System.out.println("Thank you for using..");
                break;
            default:
                System.out.println("Invalid choice .... Try again!!");
        }
    }
    private void checkbalance()
    {
        System.out.println("your bank balance is:"+account.getbalance());
    }
    private void deposit(Scanner sc)
    {
        System.out.println("enter the amount to deposit");
        double amount=sc.nextDouble();
        account.deposit(amount);
        System.out.println("your amount "+ amount+ " is deposited successfully");
    }
    private void withdraw(Scanner sc)
    {
        System.out.println("Enter the amount to be withdraw:");
        double amount=sc.nextDouble();
        if(account.withdraw(amount))
        {
            System.out.println(amount+" withdrawn successful");
        }
        else{
            System.out.println("Insufficient balance ! withdraw failed..! ");
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        bankaccount useraccount=new bankaccount(1000);
        atminterface atm=new atminterface(useraccount);
        int choice;
        do{
            atm.displaymenu();
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            atm.performaction(choice,sc);

        }while(choice!=4);
        sc.close();
    }
}