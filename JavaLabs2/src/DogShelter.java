import java.util.ArrayList;
import java.util.Scanner;

public class DogShelter {
    private ArrayList<Dog> shelter = new ArrayList<>();
    void addDog(){
        Dog pet = new Dog();
        shelter.add(pet);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DogShelter test = new DogShelter();

        System.out.print("Колличество собак: ");
        int num = in.nextInt();
        int i = 0;
        while(i < num){
            test.addDog();
            i++;
        }

        for (i = 0; i < num; i++){
            System.out.println(i+1 + ": " + test.shelter.get(i).ToString());
        }
    }
}

class Dog{
    String name;
    int age;
    Scanner in = new Scanner(System.in);
    Dog(){
        System.out.print("Age: ");
        age = in.nextInt();
        System.out.print("Name: ");
        name = in.next();
    }
    void Set_name(){
        System.out.print("Name: ");
        name = in.next();
    }
    void Set_age(){
        System.out.print("Age: ");
        age = in.nextInt();
    }
    void Get_name(){
        System.out.print("Name: " + name);
    }
    void Get_age(){
        System.out.print("Age: " + age);
    }

    void translate_to_human_age(){
        System.out.print("Human age: " + 7*age);
    }

    String ToString(){
        return "Name: " + name + "; Age: " + age;
    }
}