import java.util.Scanner;

class CircleTest{
    public static void main(String[] args) {
        Circle obj = new Circle();
        obj.set_color();
        obj.set_radius();
        obj.all_info();
    }
}

public class Circle {
    private float radius;
    private float place;
    private float large;
    private String color;
    Scanner in = new Scanner(System.in);

    void set_color(){
        System.out.print("Color of circle: ");
        color = in.next();
    }

    void set_radius(){
        System.out.print("Radius: ");
        radius = in.nextFloat();
        float pi = (float)Math.PI;
        place = pi*radius*radius;
        large = 2*pi*radius;
    }

    float get_radius(){
        return radius;
    }

    float get_place(){
        return place;
    }

    float get_large(){
        return large;
    }

    String get_color(){
        return color;
    }

    void all_info(){
        System.out.println("Radius = " + radius);
        System.out.println("Place = " + place);
        System.out.println("Large of circle = " + large);
        System.out.println("Color of cirlce = " + color);
    }
}
