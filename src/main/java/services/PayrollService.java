package services;

import java.math.BigDecimal;
import java.util.List;

import entities.Employee;

public class PayrollService {

	private static final BigDecimal percentualIncrease = new BigDecimal("0.10");

	public void applySalaryIncrease(List<Employee> employees) {
	    for (Employee employee : employees) {
	        BigDecimal newSalary = employee.getSalary().multiply(BigDecimal.ONE.add(percentualIncrease));
	        employee.setSalary(newSalary);
	    }
	}
	
}
