package Laba13.second;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    boolean correct_adress(String adress){
        int isDog = 0;
        boolean isDote = false;

        if (adress.charAt(0) >= '0' && adress.charAt(0) <= '9') return false;
        int index = adress.length() - 1;

        for (int i = 0; i < adress.length(); i++){
            if (!(adress.charAt(i) >= '0' && adress.charAt(i) <= '9' || Integer.valueOf(adress.charAt(i)) >= 65 &&
                    Integer.valueOf(adress.charAt(i)) <= 90 || Integer.valueOf(adress.charAt(i)) >= 97 &&
                    Integer.valueOf(adress.charAt(i)) <= 122 || adress.charAt(i) == '-' || adress.charAt(i) == '.' ||
                    adress.charAt(i) == '@')) return false;
            if (adress.charAt(i) == '@' && i != 0 && i != adress.length()-1) isDog ++;
            if (isDog == 1 && i > adress.indexOf('@') && adress.charAt(i) == '.' && i != adress.length()-1) isDote = true;
        }
        if(isDog == 1 && isDote){
            while(adress.charAt(index) != '.'){
                if (adress.charAt(index) >= '0' && adress.charAt(index) <= '9') return false;
                index --;
            }
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        TreeSet<String> list = new TreeSet<>();

        Scanner in = new Scanner(System.in);

        System.out.print(">>>>>>");
        String text = in.nextLine();
        String[] command = text.split(" ");

        while(true){
            switch (command[0]){
                case "ADD":{
                    if (new Main().correct_adress(text.substring(text.lastIndexOf(command[1])))){
                        list.add(text.substring(text.lastIndexOf(command[1])));
                    }else {
                        System.out.println("ERROR");
                    }
                    break;
                }
                case "LIST":{
                    if (list.isEmpty()) System.out.println("none");
                    for(String adress: list){
                        System.out.println(adress);
                    }
                    break;
                }
                case "CLOSE":{
                    return;
                }
            }

            System.out.print(">>>>>>");
            text = in.nextLine();
            command = text.split(" ");
        }

    }

}
