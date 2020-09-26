import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovableRectangle obj = new MovableRectangle(2,4);

        Scanner in = new Scanner(System.in);

        System.out.print("Speed of moving: ");
        obj.SetSpeed(in.nextDouble());

        System.out.print("Direction: ");
        obj.SetDirection(in.nextInt());

        System.out.print("Time: ");
        obj.SetTimeMoving(in.nextInt());

        System.out.print("Position(x,y):");
        obj.SetPosition(in.nextDouble(), in.nextDouble());

        obj.Move();

    }
}

abstract class Shape{
    private String name, color;
    abstract int CalcArea();

    public void SetName(String name){
        this.name = name;
    }

    public void SetColor(String color){
        this.color = color;
    }

    public String GetColor(){
        return color;
    }

    public String getName() {
        return name;
    }
}

interface Movable{
    void SetSpeed(double speed);
    void SetPosition(double x, double y);
    void SetDirection(double direction);
    void SetTimeMoving(int time);
    void Move();
}


class MovableRectangle extends Rectangle implements Movable {
    private double speed, direction;
    private int time;
    private double x = 0, y = 0; //position
    Scanner in = new Scanner(System.in);

    public MovableRectangle(int side_a, int side_b) {
        super(side_a, side_b);
    }

    public void SetPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void SetDirection(double direction) {
        this.direction = direction;
    }

    @Override
    public void SetTimeMoving(int time) {
        this.time = time;
    }

    public void SetSpeed(double speed) {
        this.speed = speed;
    }

    public void Move() {
        for (int i = 0; i < time; i++) {
            x += speed * Math.cos(direction / 57.3);
            y += speed * Math.sin(direction / 57.3);
            System.out.println("x: " + (int) x + "; y: " + (int) y);
        }
    }



}

class Rectangle extends Shape {
    private int side_a, side_b;

    public Rectangle(int side_a, int side_b) {
        this.side_a = side_a;
        this.side_b = side_b;
    }

    public int getSide_a() {
        return side_a;
    }

    public void setSide_a(int side_a) {
        this.side_a = side_a;
    }

    public int getSide_b() {
        return side_b;
    }

    public void setSide_b(int side_b) {
        this.side_b = side_b;
    }

    @Override
    public int CalcArea() {
        return side_a*side_b;
    }

}

