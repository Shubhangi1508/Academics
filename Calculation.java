
import java.util.Scanner;
public class Calculator {
    public static void addition()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int num1=sc.nextInt();
        System.out.println("Enter First Number: ");
        int num2=sc.nextInt();
        System.out.println("Addition of both nos is: "+(num1+num2));
    }
    public static void subtraction()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int num1=sc.nextInt();
        System.out.println("Enter First Number: ");
        int num2=sc.nextInt();
        System.out.println("Subtraction of both nos is: "+(num1-num2));
    }
    public static void multiplication()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number: ");
        double num1=sc.nextDouble();
        System.out.println("Enter First Number: ");
        double num2=sc.nextDouble();
        System.out.println("Product of both nos is: "+(num1*num2));
    }
    public static void division()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number: ");
        double num1=sc.nextInt();
        System.out.println("Enter First Number: ");
        double num2=sc.nextDouble();
        System.out.println("Division of both nos is: "+(num1/num2));
    }
    public static void squareroot()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int num1=sc.nextInt();
        System.out.println("Square Root of the given no is: "+Math.sqrt(num1));
    }
    public static void powerof()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the BASE number: ");
        int num1=sc.nextInt();
        System.out.println("Enter the Exponent number: ");
        double num2=sc.nextInt();
        System.out.println("Base to the power given exponent is: "+Math.pow(num1, num2));
    }
    public static void variance()
    {
        Scanner in=new Scanner(System.in);
        int a[]=new int[20];
        int i,n;
        double mean,sqrdiff=0, variance,sum=0;
        System.out.println("Enter the no of elements: ");
        n=in.nextInt();
        System.out.println("Enter "+n+" elements: ");
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
        }
        for(i=0;i<n;i++)
        {
            sum=sum+a[i];
        }
        mean=sum/n;
        for(i=0;i<n;i++)
        {
            sqrdiff+=(a[i]-mean)*(a[i]-mean);
        }
        variance=(double)sqrdiff/(n-1);
        System.out.println("The variance of the given nos is: "+variance);
    }
    public static void mean()
    {
        double sum=0,count=0;
        double mean;
        loop:
        for(;;)
        {
            System.out.println("Enter number: ");
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            count++;
            sum=sum+a;
            mean=(sum/count);
            System.out.println("Type END/end to end the calculation, if you want:");
            Scanner s=new Scanner(System.in);
            String wish=s.nextLine();
            if(wish.equals("END")||wish.equals("end"))
            {
                break loop;
            }
            else
            {
                continue loop;
            }
        }
            System.out.println("Mean of the entered nos is: "+mean);
        
    }
    public static void main(String[] args) {
        int choice=0;
        while(choice!=9)
        {
        System.out.println("\n========MAIN MENU========");
        System.out.println(" 1)ADDITION:");
        System.out.println(" 2)SUBTRACTION:");
        System.out.println(" 3)MULTIPLICATION:");
        System.out.println(" 4)DIVISION:");
        System.out.println(" 5)SQUARE ROOT:");
        System.out.println(" 6)POWER OF:");
        System.out.println(" 7)MEAN:");
        System.out.println(" 8)VARIANCE:");
        System.out.println(" 9)EXIT");
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Choice: ");
        choice=sc.nextInt();
        switch(choice)
        {
            case 1:
                addition();
                break;
            case 2:
                subtraction();
                break;
            case 3:
                multiplication();
                break;
            case 4:
                division();
                break;
            case 5:
                squareroot();
                break;
            case 6:
                powerof();
                break;
            case 7:
                mean();
                break;
            case 8:
                variance();
                break;
        }
      }
    }
}
