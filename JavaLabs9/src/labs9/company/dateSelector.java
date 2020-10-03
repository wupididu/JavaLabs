package labs9.company;

public class dateSelector implements employeeSelector{
    int year;

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean HandleEmployees(Employee employee) {
        return employee.getDateBirthday().getYear() > year;
    }
}
