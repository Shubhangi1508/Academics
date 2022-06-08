import java.util.*;

abstract class Shapes {
    public String color;
    public boolean filled;
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String DisplayDetails();
    public String getColor()
    {
        return color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public boolean isFilled()
    {
        return filled;
    }
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }
}

class Circle extends Shapes {
   public double radius;

    public Circle()
    {
        this.radius = 0.0;
    }
    public Circle(double radius)
    {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
        this.radius = radius;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double r)
    {
        this.radius = r;
    }
    public double getArea()
    {
        double area;
        area = radius*radius;
        return area;
    }
    public double getPerimeter()
    {
        double perimeter;
        perimeter = 2*3.14*radius;
        return perimeter;
    }
    public String DisplayDetails()
    {
        return "Color: "+ getColor() + "\nFill: "+ isFilled() + "\nRadius: "+ getRadius() + "\nArea: "+ 
        getArea() + "\nPerimeter: " + getPerimeter();
    }
}

class Rectangle extends Shapes
{
    public double breadth, length;
    public Rectangle()
    {
        this.length = 0.0;
        this.breadth = 0.0;
    }
    public Rectangle(double length, double breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }
    public Rectangle(double length, double breadth, String color, boolean filled)
    {
        this.length = length;
        this.breadth = breadth;
        this.color = color;
        this.filled = filled;
    }
    public double getbreadth()
    {
        return breadth;
    }
    public double getlength()
    {
        return length;
    }
    public void setbreadth(double breadth)
    {
        this.breadth = breadth;
    }
    public void setlength(double length)
    {
        this.length = length;
    }
    public double getArea()
    {
        return length*breadth;
    }
    public double getPerimeter()
    {
        return 2*(length + breadth);
    }
    public String DisplayDetails()
    {
        return "Color: "+ getColor() + "\nFill: "+ isFilled() + "\nLength: "+ getlength() + "\nBreadth: "+ 
        getbreadth() + "\nPerimeter: " + getPerimeter() + "\nArea: " + getArea();
    }
}
class Triangle extends Shapes {
    double base, altitude, side1, side2, side3;

    public Triangle() {
        base = 0.0;
        altitude = 0.0;
    }
    public Triangle(double base, double altitude, double side1, double side2, double side3, String color,
            boolean filled) 
    {
        this.base = base;
        this.altitude = altitude;
        this.color = color;
        this.filled = filled;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getaltitude() {
        return altitude;
    }

    public void setaltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        return (base * altitude) / 2;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String DisplayDetails() {
        return "Color: " + getColor() + "\nFill: " + isFilled() + "\nBase: " + getBase() + "\naltitude: " + getaltitude()
                + "\nSide 1: " + getSide1() + "\nSide 2: " + getSide2() + "\nSide 3: " + getSide3() + "\nArea: "
                + getArea() + "\nPerimeter: " + getPerimeter();
    }
}
class Square extends Rectangle
{
    public double side;
    public Square()
    {
        this.side = 0.0;
    }
    public Square(double side)
    {
        this.side = side;
    }
    public Square(double side, String color, boolean filled)
    {
        this.side = side;
        this.color = color;
        this.filled = filled;
    }
    public double getSide()
    {
        return side;
    }
    public void setSide(double side)
    {
        this.side = side;
    }
    public double getArea()
    {
        double area;
        area = side*side;
        return area;
    }
    public double getPerimeter()
    {
        double perimeter;
        perimeter = 4*side;
        return perimeter;
    }
    public String DisplayDetails()
    {
        return "Color: "+ getColor() + "\nFill: "+ isFilled() + "\nSide: "+ getSide() + "\nPerimeter: " + getPerimeter() + "\nArea: " + getArea();
    }
}
public class MyShapes
{
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        String col;
        double rad, wid, len, side, base, altitude, x, y, z;
        boolean fill;
        System.out.println("CIRCLE: \n");
        System.out.print("Enter the radius: ");
        rad = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the color: ");
        col = sc.nextLine();
        System.out.print("Fill shape?(true/false): ");
        fill = Boolean.parseBoolean(sc.nextLine());
        Circle c = new Circle(rad, col, fill);
        System.out.println("\n" + c.DisplayDetails());

        System.out.println("\n\nRECTANGLE: \n");
        System.out.print("Enter the width: ");
        wid = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the length: ");
        len = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the color: ");
        col = sc.nextLine();
        System.out.print("Fill shape?(true/false): ");
        fill = Boolean.parseBoolean(sc.nextLine());
        Rectangle r = new Rectangle(wid, len, col, fill);
        System.out.println("\n" + r.DisplayDetails());

        System.out.println("\n\nSQUARE: \n");
        System.out.print("Enter the side: ");
        side = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the color: ");
        col = sc.nextLine();
        System.out.print("Fill shape?(true/false): ");
        fill = Boolean.parseBoolean(sc.nextLine());
        Square s = new Square(side, col, fill);
        System.out.println("\n" + s.DisplayDetails());

        System.out.println("\n\nTRIANGLE: \n");
        System.out.print("Enter the base: ");
        base = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the altitude: ");
        altitude = Double.parseDouble(sc.nextLine());
        System.out.print("Enter length of side 1: ");
        x = Double.parseDouble(sc.nextLine());
        System.out.print("Enter length of side 2: ");
        y = Double.parseDouble(sc.nextLine());
        System.out.print("Enter length of side 3: ");
        z = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the color: ");
        col = sc.nextLine();
        System.out.print("Fill shape?(true/false): ");
        fill = Boolean.parseBoolean(sc.nextLine());
        Triangle t = new Triangle(base, altitude, x, y, z, col, fill);
        System.out.println("\n" + t.DisplayDetails());
        
    }
}