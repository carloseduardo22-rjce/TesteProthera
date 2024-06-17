package com.PracticeTest.PracticeTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import entities.Employee;
import factory.EmployeeFactory;
import services.EmployeeService;
import services.PayrollService;

// Requisito 3
public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        PayrollService payrollService = new PayrollService();
        EmployeeService employeeService = new EmployeeService();
        
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
        
        List<Employee> employees = new ArrayList<>();
        
        // Requisito 3.1
        for (String[] data : EMPLOYEE_DATA) {
            try {
                employees.add(EmployeeFactory.create(data[0], data[1], data[2], data[3]));
            } catch (Exception e) {
                System.err.printf("Erro ao criar funcionário com dados %s: %s%n", String.join(", ", data), e.getMessage());
            }
        }

        // Requisito 3.2
        try {
            employees.removeIf(e -> e.getName().equals("João"));
        } catch (Exception e) {
            System.err.println("Erro ao remover funcionário: " + e.getMessage());
        }

        // Requisito 3.3
        employees.forEach(System.out::println);
        String divider = new String(new char[85]).replace('\0', '-');
        System.out.println(divider);

        // Requisito 3.4
        System.out.println("Salários atualizados com aumento de 10%");
        try {
            payrollService.applySalaryIncrease(employees);
        } catch (Exception e) {
            System.err.println("Erro ao aplicar aumento salarial: " + e.getMessage());
        }
        employees.forEach(System.out::println);

        // Requisito 3.5 e 3.6
        System.out.println(divider);
        System.out.println("Funcionários por função:");
        try {
            Map<String, List<Employee>> employeesByFunction = employeeService.groupByFunction(employees);
            employeeService.printEmployeesByJob(employeesByFunction);
        } catch (Exception e) {
            System.err.println("Erro ao agrupar funcionários por função: " + e.getMessage());
        }

        // Requisito 3.8
        System.out.println(divider);
        System.out.println("Funcionários que fazem aniversário nos meses de Outubro e Dezembro:");
        try {
            employeeService.printBirthdayEmployees(employees, 10, 12);
        } catch (Exception e) {
            System.err.println("Erro ao imprimir funcionários aniversariantes: " + e.getMessage());
        }
        System.out.println(divider);
        
        // Requisito 3.9
        try {
            Employee oldestEmployee = employeeService.getOldestEmployee(employees);
            if (oldestEmployee != null) {
                int age = Period.between(oldestEmployee.getBirthDate(), LocalDate.now()).getYears();
                System.out.printf("Funcionário com a maior idade: %s, Idade: %d anos%n", oldestEmployee.getName(), age);
            }
        } catch (Exception e) {
            System.err.println("Erro ao obter funcionário mais velho: " + e.getMessage());
        }

        System.out.println();
        // Requisito 3.10
        try {
            List<Employee> sortedEmployees = employeeService.getEmployeesSortedByName(employees);
            System.out.println("Funcionários em ordem alfabética:");
            sortedEmployees.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Erro ao ordenar funcionários por nome: " + e.getMessage());
        }
        
        System.out.println();
        // Requisito 3.11
        try {
            BigDecimal totalSalaries = employeeService.getTotalSalaries(employees);
            System.out.printf("Total dos salários: R$ %.2f%n", totalSalaries);
        } catch (Exception e) {
            System.err.println("Erro ao calcular o total dos salários: " + e.getMessage());
        }
        
        System.out.println();
        // Requisito 3.12
        BigDecimal minimumWage = new BigDecimal("1212.00");
        System.out.println("Salários em salários mínimos:");
        try {
            employeeService.printSalariesInMinimumWages(employees, minimumWage);
        } catch (Exception e) {
            System.err.println("Erro ao calcular salários em salários mínimos: " + e.getMessage());
        }
    }
    
}
