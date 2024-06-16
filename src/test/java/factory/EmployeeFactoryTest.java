package factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Employee;

public class EmployeeFactoryTest {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	List<Employee> employees = new ArrayList<>();
	
	@Before
	public void setUp() {
		String[][] EMPLOYEE_DATA = {
				{"Maria", "18/10/2000", "2009.44", "Operador"},
                {"João", "12/05/1990", "2284.38", "Operador"},
                {"Caio", "02/05/1961", "9836.14", "Coordenador"},
                {"Miguel", "14/10/1988", "19119.88", "Diretor"},
                {"Alice", "05/01/1995", "2234.68", "Recepcionista"},
                {"Heitor", "19/11/1999", "1582.72", "Operador"},
                {"Arthur", "31/03/1993", "4071.84", "Contador"},
                {"Laura", "08/07/1994", "3017.45", "Gerente"},
                {"Heloísa", "24/05/2003", "1606.85", "Eletricista"},
                {"Helena", "02/09/1996", "2799.93", "Gerente"}
		};
		
		employees = new ArrayList<>();
		
		for (String[] data : EMPLOYEE_DATA) {
			employees.add(EmployeeFactory.create(data[0], data[1], data[2], data[3]));
		}
	}
	
	@Test
	public void firstEmployeeTest() {
		Employee employee = employees.get(0);
		assertEquals("Maria", employee.getName());
		assertEquals(LocalDate.parse("18/10/2000", formatter), employee.getBirthDate());
		assertEquals(new BigDecimal("2009.44"), employee.getSalary());
		assertEquals("Operador", employee.getFunction());
	}
	
	
}
