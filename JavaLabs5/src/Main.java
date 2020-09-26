import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square = new Square();

        System.out.println("Color:");
        circle.SetName();
        circle.SetColor();
        circle.SetRadius();

        System.out.println("Rectangle:");
        rectangle.SetName();
        rectangle.SetColor();
        rectangle.SetSides();

        System.out.println("Square:");
        square.SetName();
        square.SetColor();
        square.SetSides();

        circle.GetName();
        circle.GetColor();
        circle.CalcArea();

        rectangle.GetName();
        rectangle.GetColor();
        rectangle.CalcArea();

        square.GetName();
        square.GetColor();
        square.CalcArea();
    }
}


abstract class Shape{
    private String name, color;
    abstract void CalcArea();
    Scanner in = new Scanner(System.in);
    void SetName(){
        System.out.print("Name of shape: ");
        name = in.next();
    }

    void SetColor(){
        System.out.print("Color of shape: ");
        color = in.next();
    }

    void GetColor(){
        System.out.println("Color of shape: " + color);
    }

    void GetName(){
        System.out.println("Name of shape: " + name);
    }

}

class Circle extends Shape{
    private double radius;

    void SetRadius(){
        Scanner in = new Scanner(System.in);
        System.out.print("Radius: ");
        radius = in.nextDouble();
    }

    void CalcArea() {
        System.out.println("Area of Circle = " + Math.PI*Math.pow(radius, 2));
    }
}

class Rectangle extends Shape{
    private int side_a, side_b;

    void SetSides(){
        Scanner in = new Scanner(System.in);
        System.out.print("Side a: ");
        side_a = in.nextInt();
        System.out.print("Side b: ");
        side_b = in.nextInt();
    }

    @Override
    void CalcArea() {
        System.out.println("Area of Rectangle = " + side_a*side_b);
    }

}

class Square extends Shape{
    private int side;

    void SetSides(){
        Scanner in = new Scanner(System.in);
        System.out.print("Side of Square: ");
        side = in.nextInt();
    }

    @Override
    void CalcArea() {
        System.out.println("Area of Rectangle = " + side*side);
    }
}
