
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class LAB2{
    public static void ArraytoArraylist()
    {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of elements of array: ");
        n=sc.nextInt();
        int []array=new int[10];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        System.out.println("Array elements are as follows: ");
        for(int i=0;i<n;i++)
        {
            System.out.println(array[i]);
        }
        ArrayList <Integer> arraylist= new ArrayList <Integer>();
        System.out.println("New converted Arraylist: ");
        for(int i=0;i<n ;i++)
        {
            arraylist.add(new Integer(array[i]));
        }System.out.println(arraylist);
    }
    public static void SecondSmallestElement()
    {
        int n,i,j,temp;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of elements of array: ");
        n=sc.nextInt();
        int []array=new int[10];
        System.out.println("Enter the elements: ");
        for(i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(array[i]>array[j])
                {
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println("Second Smallest element of the array is: " +array[1]);
    }
    public static void difference()
    {
        int n,i,j,temp;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of elements of array: ");
        n=sc.nextInt();
        if(n>1)
        {
            int []array=new int[10];
            System.out.println("Enter the elements: ");
            for(i=0;i<n;i++)
            {
                array[i]=sc.nextInt();
            }
            for(i=0;i<n;i++)
            {
                for(j=i+1;j<n;j++)
                {
                    if(array[i]>array[j])
                    {
                        temp=array[i];
                        array[i]=array[j];
                        array[j]=temp;
                    }
                }
            }
        System.out.println("Difference between largest and smallest element is: " +(array[n-1]-array[0]));
        }
        else if(n==1)
        {
            System.out.println("Only 1 element present in the array");
        }
        else if(n==0)
        {
            System.out.println("Operation not possible with 0 elements");
        }
    }
    public static void EvenOdd()
    {
        int i,p=0,q=0,num;
        int even[]= new int[20];
        int odd[]=new int[20];
        Scanner sc=new Scanner(System.in);
        loop:
        for(i=0;;i++)
        {
            System.out.println("Enter number: ");
            num=sc.nextInt();
            if(num%2==0)
            {
                even[p++]=num;
            }
            else
            {
                odd[q++]=num;
            }
            System.out.println("Type END/end to stop taking input from user: ");
            Scanner sr=new Scanner(System.in);
            String wish=sr.nextLine();
            if(wish.equals("END")||wish.equals("end"))
            {
                break loop;
            }
            else
            {
                continue loop;
            }
        }
        for(i=0;i<p;i++)
        {
            System.out.println("Even nos Array at index ["+i+"]is: "+even[i]);
        }System.out.println("Number of elements in EVEN ARRAY is: "+p);
        System.out.println("\n");
        for(i=0;i<q;i++)
        {
            System.out.println("Odd nos Array at index ["+i+"]is: "+odd[i]);
        }System.out.println("Number of elements in ODD ARRAY is: "+q);
    }
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); 
        int choice =0;
        while(choice !=5)
        {
        System.out.println("\n========MAIN MENU========");
        System.out.println(" 1) CONVERT ARRAY TO ARRAYLIST");
        System.out.println(" 2) FIND SECOND SMALLEST ELEMENT OF THE ARRAY");
        System.out.println(" 3) DIFFERENCE BETWEEN LARGEST AND SMALLEST ELEMENT OF ARRAY");
        System.out.println(" 4) SEGERAGRATING ELEMENTS acc TO EVEN NOS ARRAY AND ODD NOS ARRAY");
        System.out.println(" 5) EXIT");
        System.out.println(" ENTER YOUR CHOICE: ");
        Scanner c=new Scanner(System.in);
        choice=c.nextInt();
        switch(choice)
        {
            case 1:
                ArraytoArraylist();
                break;
            case 2:
                SecondSmallestElement();
                break;
            case 3:
                difference();
                break;
            case 4:
                EvenOdd();
                break;
            case 5:
                System.exit(0);
         }
       }
    }
    
}

