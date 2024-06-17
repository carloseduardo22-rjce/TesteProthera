package services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import entities.Employee;
import factory.EmployeeFactory;

public class EmployeeServiceTest {
	
	private EmployeeService employeeService = new EmployeeService();
	private PayrollService payrollService = new PayrollService();
	private List<Employee> employees;
	
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
	public void testRemoveEmployee() {
		int sizeInitial = employees.size();
		employees.removeIf(f -> f.getName().equals("João"));
		assertEquals(sizeInitial - 1, employees.size());
	}
	
	@Test
	public void testApplySalaryIncrease() {
		payrollService.applySalaryIncrease(employees);
		assertEquals(new BigDecimal("2210.3840"), employees.get(0).getSalary());
	}
	
	@Test
	public void testGetTotalSalaries() {
		employees.removeIf(f -> f.getName().equals("João"));
		payrollService.applySalaryIncrease(employees);
		BigDecimal totalSalaries = employeeService.getTotalSalaries(employees);
		BigDecimal expectedTotalSalaries = employees.stream()
				.map(Employee::getSalary)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		assertEquals(expectedTotalSalaries, totalSalaries);
	}
	
	@Test
	public void totalFunctions() {
		Map<String, List<Employee>> groupByFunction = employeeService.groupByFunction(employees);
		assertEquals(7, groupByFunction.size());
	}
	
	@Test
	public void testGetOldestEmployee() {
		Employee oldestEmployee = employeeService.getOldestEmployee(employees);
		assertEquals("Caio", oldestEmployee.getName());
	}
	
	@Test
	public void testGetEmployeesSortedByName() {
		List<Employee> sortedEmployees = employeeService.getEmployeesSortedByName(employees);
		assertEquals("Alice", sortedEmployees.get(0).getName());
		assertEquals("Miguel", sortedEmployees.get(sortedEmployees.size() - 1).getName());
	}
	
}

