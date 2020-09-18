import java.util.Scanner;

public class Human {
    private int height;
    private String color, name, gender;
    private int weight;
    Leg foot_of_person = new Leg();
    Head head_of_person = new Head();
    Hand hand_of_person = new Hand();

    Human(){
        Scanner in = new Scanner(System.in);
        System.out.print("Name of human: ");
        name = in.next();
        System.out.print("Gender of person: ");
        gender = in.next();
        System.out.print("Height of human: ");
        height = in.nextInt();
        System.out.print("Color of skin: ");
        color = in.next();
        System.out.print("Weight: ");
        weight = in.nextInt();

        foot_of_person.set_info();
        hand_of_person.set_info();
        head_of_person.set_info();
    }

    void get_all_info(){
        System.out.println("Name of human: " + name);
        System.out.println("Gender of person: " + gender);
        System.out.println("Height of human: " + height);
        System.out.println("Color of skin: " + color);
        System.out.println("Weight: " + weight);
        foot_of_person.get_info();
        head_of_person.get_info();
        hand_of_person.get_info();
    }

    public static void main(String[] args) {
        Human pers = new Human();
        pers.get_all_info();
    }
}

class Leg{
    private int amount;
    private String health;
    void set_info(){
        Scanner in = new Scanner(System.in);
        System.out.print("Amount of legs: ");
        amount = in.nextInt();
        System.out.print("Health of the feet: ");
        health = in.next();
    }

    void get_info(){
        System.out.println("Amount of legs: " + amount);
        System.out.println("Health of the feet: " + health);
    }
}

class Head{
    private String color_of_hair, color_of_eye;
    void set_info(){
        Scanner in = new Scanner(System.in);
        System.out.print("Color of hair: ");
        color_of_hair = in.next();
        System.out.print("Color of eye: ");
        color_of_eye = in.next();
    }

    void get_info(){
        System.out.println("Color of hair: " + color_of_hair);
        System.out.println("Color of eye: " + color_of_eye);
    }
}

class Hand{
    private int amount;
    private String health;
    void set_info(){
        Scanner in = new Scanner(System.in);
        System.out.print("Amount of hands: ");
        amount = in.nextInt();
        System.out.print("Health of the hands: ");
        health = in.next();
    }

    void get_info(){
        System.out.println("Amount of hands: " + amount);
        System.out.println("Health of the hands: " + health);
    }
}
