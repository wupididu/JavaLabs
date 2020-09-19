import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Shape figure = new Shape();
        System.out.println(figure.form);
        figure.set();
        figure.get();
    }

}

class Shape{
    String form = "Triangle";
    private double area, a, b, c, P;
    void set(){
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("a, b, c: ");
            a = in.nextDouble();
            b = in.nextDouble();
            c = in.nextDouble();
        }while(a >= b+c || b >= a+c || c >= a+b );
        P = a + b + c;
        double p = P/2;
        area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    void get(){
        System.out.println(form);
        System.out.println("a: " + a + "; b: " + b + "; c: " + c);
        System.out.print("area: ");
        System.out.format("%.3f%n", area);
        System.out.println("P: " + P);
    }
}