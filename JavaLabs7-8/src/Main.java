public class Main {

}

interface EmployeePosition{
    String getJobTitle();
    double calcSalary(double baseSalary);
}

class Employee {
    protected String surname, name, jobTitle;
    protected int baseSalary;

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

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
}


class Manager extends Employee implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        int cash = (int)(Math.random()*25000) + 115000;
        return baseSalary + cash*0.05;
    }
}

class TopManager extends Employee implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return 0;
    }
}

class Operator extends Employee implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}