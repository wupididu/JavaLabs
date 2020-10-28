package labs12.second;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data_FIO data_fio = new Data_FIO();
        Scanner in = new Scanner(System.in);
        String text = in.next();
        data_fio.set_text(text);
        System.out.println();
        while(true){
            if (data_fio.correct_text()){
                data_fio.set();
                System.out.println("Фамилия: " + data_fio.getSurname());
                System.out.println("Имя: " + data_fio.getName());
                System.out.println("Отчество: " + data_fio.getMiddle_name());
            }else {
                System.out.println("Введенная строка не является ФИО");
            }

            if (in.toString() == "exit") return;
            text = in.next();
            data_fio.set_text(text);
        }

    }
}
