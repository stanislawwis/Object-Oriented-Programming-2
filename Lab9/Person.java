import java.util.Objects;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Person {
	private String surname;
	private String name;
	private Integer age;

	public Person(String _name, String _surname, Integer _age) {
		name = _name;
		surname = _surname;
		age = _age;
	}

	public Integer age() {
		return age;
	}

	public String name() {
		return name;
	}

	public String surname() { 
		return surname;
	}

	// Person{name='Adam', surname='Nowak', age=17}
	public String toString() {
		return "Person{name='" + name + "', surname='" + surname + "', age=" + age + "}";
	}

	public int hashCode() {
		return Objects.hash(surname, name, age);
	}

	public boolean equals(Object rhs) {
		return hashCode() == (rhs.hashCode());
	}
}