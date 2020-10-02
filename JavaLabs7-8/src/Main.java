import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    String setName(){
        int rand = (int)(Math.random()*3);
        switch (rand){
            case 0:
                return "Владимир";
            case 1:
                return "Иван";
            case 2:
                return "Аркадий";
        }
        return null;
    }

    String setSurname(){
        int rand = (int)(Math.random()*3);
        switch (rand){
            case 0:
                return "Пупкин";
            case 1:
                return "Щербаков";
            case 2:
                return "Путин";
        }
        return null;
    }

    public static void main(String[] args) {
        Company company = new Company();
        Main main = new Main();
        for (int i =0;i<180;i++){
            Employee employee = new Employee();
            EmployeePosition operator = new Operator();
            employee.setEmployeePosition(operator);
            employee.setBaseSalary((Math.random()*30000)+30000);
            employee.setName(main.setName());
            employee.setSurname(main.setSurname());
            company.hire(employee);
        }

        for (int i = 0; i < 80; i++){
            Employee employee = new Employee();
            EmployeePosition manager = new Manager();
            employee.setEmployeePosition(manager);
            employee.setBaseSalary((Math.random()*20000)+100000);
            employee.setName(main.setName());
            employee.setSurname(main.setSurname());
            company.hire(employee);
        }

        for (int i = 0; i < 10; i++){
            Employee employee = new Employee();
            EmployeePosition topManager = new TopManager();
            employee.setEmployeePosition(topManager);
            employee.setBaseSalary((Math.random()*20000)+100000);
            employee.setName(main.setName());
            employee.setSurname(main.setSurname());
            company.hire(employee);
        }

        System.out.println("Top list:");
        List<Employee> staffDown = company.getLowestSalaryStaff(15);
        for (int i = 0; i < 15; i++){
            System.out.println((int)staffDown.get(i).getEmployeePosition().calcSalary(staffDown.get(i).getBaseSalary(),
                    company) + " руб. Должность " + company.staff.get(i).getEmployeePosition().getJobTitle()
                    + " " + staffDown.get(i).getName() + " " + staffDown.get(i).getSurname());
        }

        System.out.println("Lowset list:");
        List<Employee> staffUp = company.getTopSalaryStaff(30);
        for (int i = 0; i<30; i++){
            System.out.println((int)staffUp.get(i).getEmployeePosition().calcSalary(staffUp.get(i).getBaseSalary(),
                    company) + " руб. Должность " + company.staff.get(i).getEmployeePosition().getJobTitle()
                    + " " + staffUp.get(i).getName() + " " + staffUp.get(i).getSurname());
        }

        for (int i = 0; i < company.staff.size(); i += 2){
            company.fire(i);
        }

        System.out.println("Увальнение 50% работников.");

        System.out.println("Top list:");
        staffDown = company.getLowestSalaryStaff(15);
        for (int i = 0; i < 15; i++){
            System.out.println((int)staffDown.get(i).getEmployeePosition().calcSalary(staffDown.get(i).getBaseSalary(),
                    company) + " руб. Должность " + company.staff.get(i).getEmployeePosition().getJobTitle()
                    + " " + staffDown.get(i).getName() + " " + staffDown.get(i).getSurname());
        }

        System.out.println("Lowset list:");
        staffUp = company.getTopSalaryStaff(30);
        for (int i = 0; i<30; i++){
            System.out.println((int)staffUp.get(i).getEmployeePosition().calcSalary(staffUp.get(i).getBaseSalary(),
                    company) + " руб. Должность " + company.staff.get(i).getEmployeePosition().getJobTitle()
                    + " " + staffUp.get(i).getName() + " " + staffUp.get(i).getSurname());
        }

    }
}

interface EmployeePosition{
    String getJobTitle();
    double calcSalary(double baseSalary, Company company);
}

class Employee {
    private String surname, name;
    private double baseSalary;
    private EmployeePosition employeePosition;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name + " " + surname;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setEmployeePosition(EmployeePosition employeePosition){
        this.employeePosition = employeePosition;
    }

    public EmployeePosition getEmployeePosition(){
        return employeePosition;
    }
}

class Manager implements EmployeePosition{
    private double cash = (Math.random()*25000) + 115000;
    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary, Company company) {
        return baseSalary + cash*0.05;
    }

    public double getCash(){
        return cash;
    }
}

class TopManager implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary, Company company) {
        if (company.getIncome() >= 10000000)
            return baseSalary*2.5;
        else
            return baseSalary;
    }
}

class Operator implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary, Company company) {
        return baseSalary;
    }
}

class Company {
    List<Employee> staff = new ArrayList<>();
    double income = 0;
    void hire(Employee employee){
        staff.add(employee);
    }

    void hireAll(List<Employee> stuff){
        this.staff.addAll(stuff);
    }

    void fire (int index){
        staff.remove(index);
    }

    double getIncome (){
        for(int i =0; i < staff.size(); i++){
            if (staff.get(i).getEmployeePosition().getClass() == Manager.class){
                income += ((Manager) staff.get(i).getEmployeePosition()).getCash();
            }
        }
        return income;
    }


    List<Employee> getTopSalaryStaff(int count){
        Comparator<Employee> comparator = Comparator.comparing(obj -> obj.getEmployeePosition().calcSalary(obj.getBaseSalary(), this));
        Collections.sort(staff, comparator);
        return staff.subList(0, count);
    }

    List<Employee> getLowestSalaryStaff(int count){
        Comparator<Employee> comparator = Comparator.comparing(obj -> obj.getEmployeePosition().calcSalary(obj.getBaseSalary(), this));
        Collections.sort(staff, comparator);
        Collections.reverse(staff);
        return staff.subList(0, count);
    }
}