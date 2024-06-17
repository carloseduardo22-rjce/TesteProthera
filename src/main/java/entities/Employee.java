package entities;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

// Requisito 2
public class Employee extends Person {

	private BigDecimal salary;
	private String function;
	
	public Employee(String name, LocalDate birthDate, BigDecimal salary, String function) {
		super(name, birthDate);
		this.salary = salary;
		this.function = function;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
        this.function = function;
    }
	
	// Requisito 3.3
	@Override
    public String toString() {
        Locale localeBR = new Locale("pt", "BR");
        return super.toString() + 
               ", Salário: " + String.format(localeBR, "%,.2f", salary) + 
               ", Função: " + function;
    }
	
}
