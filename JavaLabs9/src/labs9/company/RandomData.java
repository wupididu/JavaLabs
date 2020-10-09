package labs9.company;

import java.util.ArrayList;
import java.util.Collections;

public class RandomData {
    ArrayList<String> baseName = new ArrayList<>();
    ArrayList<String> baseSurname = new ArrayList<>();

    String getName(){
        baseName.add("Иван");
        baseName.add("Андрей");
        baseName.add("Сергей");
        baseName.add("Владислав");
        Collections.shuffle(baseName);
        return baseName.get(0);
    }

    String getSurname(){
        baseSurname.add("Иванов");
        baseSurname.add("Попов");
        baseSurname.add("Путин");
        Collections.shuffle(baseSurname);
        return baseSurname.get(0);
    }

    int getBaseSalary(){
        return (int)(Math.random()*100_000 + 70_000);
    }

    int randomYear(){
        return  (int)(Math.random()*30+1970);
    }

    int randomMonth(){
        return (int)(Math.random()*12 + 1);
    }

    int randomDay(){
        return (int)(Math.random()*27 + 1);
    }

    int getNumber(){
        return (int)(8_900_000 + Math.random()*90_000);
    }
}
