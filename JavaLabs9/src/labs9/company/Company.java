package labs9.company;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> staff = new ArrayList<>();

    void hire(Employee employee){
        staff.add(employee);
    }

    void fire(Employee employee){
        staff.remove(employee);
    }
}
