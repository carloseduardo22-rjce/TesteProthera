package factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import entities.Employee;

public class EmployeeFactory {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);

    public static Employee create(String name, String birthDate, String salary, String jobTitle) {
        LocalDate date = LocalDate.parse(birthDate, formatter);
        BigDecimal salaryDecimal = new BigDecimal(salary);
        return new Employee(name, date, salaryDecimal, jobTitle);
    }
	
}
