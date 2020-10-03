package labs9.company;


import javax.swing.text.DateFormatter;
import java.time.LocalDate;

public class Employee {
    private String name, surname;
    private double baseSalary;
    private int phoneNumber;
    private String residence;
    private final LocalDate dateBirthday;


    public Employee(String name, String surname, double baseSalary, int phoneNumber, String residence, LocalDate dateBirthday) {
        this.name = name;
        this.surname = surname;
        this.baseSalary = baseSalary;
        this.phoneNumber = phoneNumber;
        this.residence = residence;
        this.dateBirthday = dateBirthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public LocalDate getDateBirthday() {
        return dateBirthday;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", baseSalary=" + baseSalary +
                ", phoneNumber=" + phoneNumber +
                ", residence='" + residence + '\'' +
                ", dateBirthday=" + dateBirthday +
                '}';
    }
}
