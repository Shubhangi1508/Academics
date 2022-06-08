
import java.util.*;

class Student
{
    public String name;
    public int Rollcall;
    public int Maths, DS, PBL;

    Scanner stringInput = new Scanner(System.in);
    Scanner intInput = new Scanner(System.in);

    public Student()
    {
        name = "";
        Rollcall = 0;
        Maths = DS = PBL = 0;
    }
    public Student(String name, int Rollcall, int Maths, int DS, int PBL)
    {
        this.name = name;
        this.Rollcall = Rollcall;
        this.Maths = Maths;
        this.DS = DS;
        this.PBL = PBL;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getRollcall()
    {
        return Rollcall;
    }
    public void setRollcall(int Rollcall)
    {
        this.Rollcall = Rollcall;
    }
    public int getMaths()
    {
        return Maths;
    }
    public void setMaths(int Maths)
    {
        this.Maths = Maths;
    }
    public int getDS()
    {
        return DS;
    }
    public void setDS(int DS)
    {
        this.DS = DS;
    }
    public int getPBL()
    {
        return PBL;
    }
    public void setPBL(int PBL)
    {
        this.PBL = PBL;
    }
    void getData()
    {
        System.out.println("*****INPUT DETAILS*****");
        System.out.print("Enter NAME: ");
        name = stringInput.nextLine();
        System.out.print("Enter ROLL-CALL: ");
        Rollcall = intInput.nextInt();
        System.out.println("\n(Marks should be entered out of 100)");
        System.out.print("Enter MARKS scored in MATHS: ");
        Maths = intInput.nextInt();
        System.out.print("Enter MARKS scored in DS: ");
        DS = intInput.nextInt();
        System.out.print("Enter MARKS scored in PBL: ");
        PBL = intInput.nextInt();
    }
}
interface Exam
{
    double calculatePercentage();
}
public class Result extends Student implements Exam
{
    public static void main(String[] args) {
        Result res = new Result();
        System.out.print("\033[H\033[2J");
        res.getData();
        System.out.println("\n######## RESULT CARD #########\n");
        System.out.println(" NAME: " + res.getName());
        System.out.println(" ROLL-CALL: " + res.getRollcall());
        System.out.println(" MATHS SCORE: " + res.getMaths());
        System.out.println(" DS SCORE: " + res.getDS());
        System.out.println(" PBL SCORE: " + res.getPBL());
        System.out.println(" PERCENTAGE SCORED: " + res.calculatePercentage());
        System.out.println("\n##############################\n");
    }
    public double calculatePercentage()
    {
        int total = Maths + DS + PBL;
        double percentage = (double)total/4;
        return percentage;
    }
}

