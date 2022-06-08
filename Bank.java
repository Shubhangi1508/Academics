import java.util.*;

class Account
{
    public String cus_name;
    public int acc_num;

    Scanner input = new Scanner(System.in);

    public Account()
    {
        String cus_name = "";
        int acc_num = 0;
    }
    public Account(String cus_name, int acc_num)
    {
        this.cus_name = cus_name;
        this.acc_num = acc_num;
    }
    public void getData()
    {
        System.out.print("Enter Customer Name: ");
        cus_name = input.nextLine();
        System.out.print("Enter Account Number: ");
        acc_num = input.nextInt();
    }
    public void putData()
    {
        System.out.println(" CUSTOMER NAME: " + cus_name);
        System.out.println(" ACCOUNT NUMBER: " + acc_num);
    }
}
class Saving_acc extends Account
{
    public double min_bal;
    public double sav_bal;

    Scanner sc = new Scanner(System.in);

    public Saving_acc()
    {
        double min_bal = 0.0;
        double sav_bal = 0.0;
    }
    public Saving_acc(double min_bal, double sav_bal)
    {
        this.min_bal = min_bal;
        this.sav_bal = sav_bal;
    }
    public void getData()
    {
        super.getData();
        System.out.print("Enter MIN BALANCE: ");
        min_bal = sc.nextDouble();
        System.out.print("Enter SAVINGS BALANCE: ");
        sav_bal = sc.nextDouble();
    }
    public void putData()
    {
        super.putData();
        System.out.println(" MIN BALANCE: " + min_bal);
        System.out.println(" SAVINGS BALANCE: " + sav_bal);
    }
}
class AccDetails extends Saving_acc
{
    Scanner s = new Scanner(System.in);
    double deposit;
    double withdrawl;

    public AccDetails()
    {
        double deposit = 0.0;
        double withdrawl = 0.0;
    }
    public AccDetails(double deposit, double withdrawl)
    {
        this.deposit = deposit;
        this.withdrawl = withdrawl;
    }
    public void getData()
    {
        super.getData();
        System.out.print("Enter amount DEPOSITED: ");
        deposit = s.nextDouble();
        sav_bal += deposit;
        System.out.print("Enter WITHDRAWL amount: ");
        withdrawl = s.nextDouble();
        sav_bal -=withdrawl;
    }
    public void putData()
    {
        super.putData();
        System.out.println(" AMOUNT DEPOSITED: " + deposit);
        System.out.println(" WITHDRAWL AMOUNT: " + withdrawl);
        if(min_bal > sav_bal)
        {
            System.out.println("\nYour current Balance is very LOW, please add funds to avoid future desperancies");
        }
    }
}
public class Bank
{
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.println("********** WELCOME **********");
        AccDetails ac = new AccDetails();
        ac.getData();
        System.out.println("\n*********** ACCOUNT DETAILS *********** ");
        ac.putData();
        System.out.println("*****************************************");
    }
}
