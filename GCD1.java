import java.util.Scanner;
class GCD1
{
    public static int findGCD(int num1,int num2)
    {
        if(num2==0)
        {
            return num1;
        }
        else if(num1>num2 && num2>0)
        {
            return findGCD(num2,num1%num2);
        }
        return findGCD(num2,num1%num2);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int num1=sc.nextInt();
        System.out.println("Enter Second Number: ");
        int num2=sc.nextInt();
        System.out.println("GCD of given 2 nos is: "+findGCD(num1,num2));
    }
}
