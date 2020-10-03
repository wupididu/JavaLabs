package labs9.company;

public class dateSelector implements employeeSelector{


    @Override
    public boolean HandleEmployees(Employee employee) {
        return employee.getDateBirthday().getYear() > 1980;
    }
}
