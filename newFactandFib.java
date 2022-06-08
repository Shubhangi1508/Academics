
import java.io.*;
import java.util.Scanner;
public class newFactandFib {
    public static void Factorial()throws IOException
    {
        int i,fact=1;
        System.out.println("Enter a Number: ");
        Scanner sc=new Scanner(new InputStreamReader(System.in));
        int num=(sc.nextInt());
        for(i=1;i<=num;i++)
        {
               fact=fact*i;
        }
        System.out.println("Factorial of the given number is: "+fact);
    }
    public static void Fibonacci()throws IOException
    {
        int a=0,b=0,c=1;
        System.out.println("Enter value of n");
        Scanner sc=new Scanner(new InputStreamReader(System.in));
        int n=(sc.nextInt());
        System.out.println("Fiboacci Series: ");
        for(int i=1;i<=n;i++)
        {
            a=b;
            b=c;
            c=a+b;
            System.out.println(a+" ");
        }
    }
    public static void main(String[] args)throws IOException {
        System.out.print("\033[H\033[2J"); 
        int choice=0;
        while(choice!=3)
        {
            System.out.println("\n========MAIN MENU=========");
            System.out.println(" 1)FACTORIAL OF A NUMBER");
            System.out.println(" 2)FIBONACCI SERIES");
            System.out.println(" 3)EXIT");
            System.out.println("Enter Your Choice:");
            Scanner sc=new Scanner(new InputStreamReader(System.in));
            choice=(sc.nextInt());
            switch(choice)
            {
                case 1:
                   Factorial();
                   break;
                case 2:
                   Fibonacci();
                   break;
                case 3:
                   System.exit(0);
            }

        }
    }
}
