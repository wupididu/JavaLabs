package labs14.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();

        todoList.add("Первый");
        todoList.add("Второй");
        todoList.add("Третий");
        todoList.add("Четвертый");
        todoList.add("Пятый");

        todoList.contains("Пятый"); //Возвращает булевую переменную

        todoList.forEach(System.out::println); //Работает как for each. Нужно передать какой-то метод.

        System.out.println("================");
        Collections.sort(todoList);

        todoList.forEach(System.out::println);

        System.out.println("================");
        System.out.println(todoList.get(Collections.binarySearch(todoList,"Пятый")));

        HashSet<String> test = new HashSet<>(todoList);

        test.contains("Пятый");

        long start = System.nanoTime();

        //

        long end = System.nanoTime() - start;
    }
}
