package Laba13.first;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("List of command:\n   LIST: get task list;\n   ADD: add task;\n   EDIT: change task in" +
                " number;\n   DELETE: delete task of this number;\n");

        System.out.print(">>>>");
        String com = in.nextLine();
        String[] command = com.split(" ");

        while(!command[0].equals("CLOSE")) {
            switch (command[0]) {
                case "LIST": {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + 1 + ": " + list.get(i).toString());
                    }
                    break;                }
                case "ADD": {
                    if (new Main().isDigit(command[1]) && Integer.parseInt(command[1]) < list.size()) {
                        list.add(Integer.parseInt(command[1]) -1, com.substring(com.lastIndexOf(command[2])));
                    } else if (!(new Main().isDigit(command[1]))) {
                        list.add(com.substring(com.lastIndexOf(command[1])));
                    } else {
                        System.out.println(">>>> ERROR");
                    }
                    break;
                }
                case "EDIT": {
                    if (new Main().isDigit(command[1]) && Integer.parseInt(command[1]) < list.size()) {
                        list.set(Integer.parseInt(command[1]) -1, com.substring(com.lastIndexOf(command[2])));
                    }else {
                        System.out.println(">>>> ERROR");
                    }
                    break;
                }
                case "DELETE": {
                    if (new Main().isDigit(command[1]) && Integer.parseInt(command[1]) < list.size()) {
                        list.remove(Integer.parseInt(command[1]) - 1);
                    }else {
                        System.out.println(">>>> ERROR");
                    }
                    break;
                }

            }
            System.out.print(">>>>");
            com = in.nextLine();
            command = com.split(" ");
        }

    }
}
