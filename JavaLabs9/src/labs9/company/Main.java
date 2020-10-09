package labs9.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {



    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 10; i++){
            Employee employee = new Employee(new RandomData().getName(),
                    new RandomData().getSurname(),
                    new RandomData().getBaseSalary(),
                    new RandomData().getNumber(),
                    "Москва",
                    LocalDate.of(new RandomData().randomYear(),
                    new RandomData().randomMonth(),
                    new RandomData().randomDay()));
            company.hire(employee);
        }

        dateSelector selector = new dateSelector();
        selector.setYear(1980);
        int count = 0;
        for (int i = 0; i<10;i++){
            if(selector.HandleEmployees(company.getStaff().get(i))){
                System.out.println(company.getStaff().get(i).toString());
                count ++;
            }
        }
        System.out.println("count = " + count);

        employeeSelector salSelector = new employeeSelector() {
            @Override
            public boolean HandleEmployees(Employee employee) {
                return employee.getBaseSalary() >120_000;
            }
        };

        count = 0;
        for (int i = 0; i<10;i++){
            if(salSelector.HandleEmployees(company.getStaff().get(i))){
                System.out.println(company.getStaff().get(i).toString());
                count ++;
            }
        }
        System.out.println("count = " + count);

        employeeSelector monthSelector = employee -> employee.getDateBirthday().getDayOfMonth() > 20;

        count = 0;
        for (int i = 0; i<10;i++){
            if(monthSelector.HandleEmployees(company.getStaff().get(i))){
                System.out.println(company.getStaff().get(i).toString());
                count ++;
            }
        }
        System.out.println("count = " + count);

    }
}
