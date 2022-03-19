public class PersonBuilder {
	private String name;
	private String surname;
	private Integer age;

	public PersonBuilder name(String _name) {
		name = _name;
		return this;
	}
	public PersonBuilder surname(String _surname) {
		surname = _surname;
		return this;
	}
	public PersonBuilder age(Integer _age) {
		age = _age;
		return this;
	}
	public Person build() {
		return new Person(name, surname, age);
	}
}