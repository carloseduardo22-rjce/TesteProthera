package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entities.Employee;

public class EmployeeService {
	
    public Map<String, List<Employee>> groupByFunction(List<Employee> employees) {
        Map<String, List<Employee>> employeesByFunction = new HashMap<>();
        for (Employee employee : employees) {
            String function = employee.getFunction();
            if (!employeesByFunction.containsKey(function)) {
                employeesByFunction.put(function, new ArrayList<>());
            }
            employeesByFunction.get(function).add(employee);
        }
        return employeesByFunction;
    }

    public void printEmployeesByJob(Map<String, List<Employee>> employeesByFunction) {
        for (Map.Entry<String, List<Employee>> entry : employeesByFunction.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            System.out.printf("%-20s %-20s %-20s %-20s\n", "Nome", "Data de Nascimento", "Salário", "Função");
            for (Employee employee : entry.getValue()) {
                String dataNascimento = employee.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String salarioFormatado = formatValue(employee.getSalary());
                System.out.printf("%-20s %-20s %-20s %-20s\n", employee.getName(), dataNascimento, salarioFormatado, employee.getFunction());
            }
            
            System.out.println();
        }
    }

    public void printBirthdayEmployees(List<Employee> employees, int... months) {
        for (int month : months) {
            List<Employee> employeesWithBirthdayInMonth = employees.stream()
                .filter(e -> e.getBirthDate().getMonthValue() == month)
                .collect(Collectors.toList());

            System.out.println("Mês: " + month);
            System.out.printf("%-20s %-20s %-20s %-20s\n", "Nome", "Data de Nascimento", "Salário", "Função");
            if (employeesWithBirthdayInMonth.isEmpty()) {
                System.out.println("Não existe funcionário que faça aniversário neste mês");
            } else {
                for (Employee employee : employeesWithBirthdayInMonth) {
                    String dataNascimento = employee.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    String salarioFormatado = formatValue(employee.getSalary());
                    System.out.printf("%-20s %-20s %-20s %-20s\n", employee.getName(), dataNascimento, salarioFormatado, employee.getFunction());
                }
            }
            
            System.out.println();
        }
    }
    
    public Employee getOldestEmployee(List<Employee> employees) {
        return employees.stream()
                .min(Comparator.comparing(Employee::getBirthDate))
                .orElse(null);
    }

    public List<Employee> getEmployeesSortedByName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public BigDecimal getTotalSalaries(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void printSalariesInMinimumWages(List<Employee> employees, BigDecimal minimumWage) {
        System.out.printf("%-20s %-20s\n", "Nome", "Salários Mínimos");
        for (Employee employee : employees) {
            BigDecimal numberOfMinimumWages = employee.getSalary().divide(minimumWage, 0, RoundingMode.FLOOR);
            System.out.printf("%-20s %-20s\n", employee.getName(), numberOfMinimumWages);
        }
    }

    private String formatValue(BigDecimal valor) {
        return String.format("%.2f", valor);
    }
}
