package first;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Table {
    private static final String url = "lib/movementList.csv";
    private static ArrayList<String[]> list = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new FileReader(url));
    private String line = null;

    Table() throws IOException {
        while((line = reader.readLine()) != null){
            String[] l = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            list.add(l);
        }
    }

    public void getAll(){
        for(String[] term: list){
            for(String ter: term){
                System.out.print(ter + "||||");
            }
            System.out.println();
        }
    }

    public float getComing(int i){
        int index = 0;
        while(!list.get(0)[index].equals("Приход") && index < list.get(0).length) index++;
        if (index > list.get(0).length) return 0;
        if(list.get(i)[index].contains("\"")){
            String tr = list.get(i)[index].replace(",",".");
            return Float.valueOf(tr.substring(1,list.get(i)[index].length()-1));
        }

        return Float.valueOf(list.get(i)[index]);
    }

    public float getCost(int i){
        int index = 0;
        while(!list.get(0)[index].equals("Расход") && index < list.get(0).length) index++;
        if (index >= list.get(0).length) return 0;
        if(list.get(i)[index].contains("\"")){
            String tr = list.get(i)[index].replace(",",".");
            return Float.valueOf(tr.substring(1,list.get(i)[index].length()-1));
        }
        return Float.valueOf(list.get(i)[index]);
    }

    public String getName(int i){
        int index = 0;
        while(!list.get(0)[index].equals("Описание операции") && index < list.get(0).length) index++;
        if (index > list.get(0).length) return null;
        int begin = list.get(i)[index].indexOf("\\");
        if(begin < 0) begin = list.get(i)[index].indexOf("/");
        int end = list.get(i)[index].indexOf("  ", begin);
        return list.get(i)[index].substring(begin,end);
    }

    public int getSize(){
        return list.size();
    }
}
