package Laba13.third;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    String get(Set<Map.Entry<String, String>> set, String number){
        for (Map.Entry<String,String> con: set){
            if (number.equals(con.getValue()))
                return con.getKey() + " " + con.getValue();
        }
        return "ERROR";
    }

    public static void main(String[] args) {
        Map<String, String> contact = new HashMap<>();
        Scanner in = new Scanner(System.in);

        System.out.println("List of command:\n   NAME: set name;\n   NUMBER: set number;\n   LIST: get all info\n");

        while(true) {
            String command;
            Number number = new Number();
            System.out.print(">>>>>>");
            command = in.nextLine();
            switch (command) {
                case "NAME": {
                    System.out.print("name: ");
                    String name = in.nextLine();
                    if (contact.containsKey(name)) {
                        System.out.println(name + " " + contact.get(name));
                    } else {
                        System.out.print("number: ");
                        number.setPhoneNumber(in.nextLine());
                        while (!number.correct_number()) {
                            System.out.print("ERROR\n number:");
                            number.setPhoneNumber(in.nextLine());}
                        contact.put(name, number.refactor_number());
                    }
                    System.out.println(number.refactor_number());
                    break;
                }
                case "NUMBER": {
                    System.out.print("number: ");
                    number.setPhoneNumber(in.nextLine());
                    while (!number.correct_number()) {
                        System.out.print("ERROR\nnumber:");
                        number.setPhoneNumber(in.nextLine());}
                    if (contact.containsValue(number.refactor_number())) {
                        System.out.println(new Main().get(contact.entrySet(), number.refactor_number()));
                    } else {
                        System.out.print("name: ");
                        contact.put(in.nextLine(), number.refactor_number());
                    }
                    System.out.println(number.refactor_number());
                    break;
                }
                case "LIST": {
                    Set<Map.Entry<String, String>> set;
                    set = contact.entrySet();
                    for (Map.Entry<String, String> con : set) {
                        System.out.println(con.getKey() + " " + con.getValue());
                    }
                    break;
                }
                case "CLOSE": {
                    return;
                }
            }
        }
    }
}
