package entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Requisito 1
public class Person {
	
	private String name;
	private LocalDate birthDate;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Person(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	
	// Requirement 3.3
	@Override
	public String toString() {
		return "Nome: " + name + ", Data de Nascimento: " + birthDate.format(formatter);
	}
	
}
