package labs12.thirt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Number number = new Number();
        Scanner in = new Scanner(System.in);
        System.out.print(">>>>");
        String num = in.next();
        while(num != "close"){
            number.setPhoneNumber(num);
            if (number.correct_number()) {
                System.out.println("Correct format: "+number.refactor_number());
            }
            else System.out.println("Wrong number");

            System.out.print(">>>>");
            num = in.next();
        }



    }
}
