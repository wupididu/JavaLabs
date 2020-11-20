package first;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, Float> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Table table = new Table();
        System.out.println("Сумма расходов : " + getAllCost(table));
        System.out.println("Сумма доходов : " + getAllComing(table) + "\n\n");
        listOfCost(table);
    }

    public static void listOfCost(Table table){
        for (int i = 1; i < table.getSize(); i++){
            if(map.containsKey(table.getName(i)))
                map.put(table.getName(i), map.get(table.getName(i))+table.getCost(i));
            else
                map.put(table.getName(i), table.getCost(i));
        }
        for(Map.Entry<String,Float> entry : map.entrySet()){
            if(entry.getKey().contains("/"))
                System.out.println(entry.getKey().replace("/"," ") + " : " + entry.getValue() + "руб");
            else
                System.out.println(entry.getKey().replace("\\"," ") + " : " + entry.getValue() + "руб");
        }
    }




    public static float getAllComing(Table table){
        float sum = 0;
        for(int i = 1; i < table.getSize(); i++)
            sum += table.getComing(i);
        return sum;
    }

    public static float getAllCost(Table table){
        float sum = 0;
        for(int i = 1; i < table.getSize(); i++){
            sum += table.getCost(i);
        }
        return sum;
    }


}
