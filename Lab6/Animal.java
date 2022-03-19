abstract public class Animal {
	private String name;
	private Integer weight;
	private Integer age;

	Animal(String _name, Integer _weight, Integer _age) {
		name = _name;
		weight = _weight;
		age = _age;
	}

	abstract public String getKind();

	void setName(String _name) {
		name = _name;
	}

	public String getName() {
		return name;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getAge() {
		return age;
	}

	public Integer compare(Animal rhs) {
		return !(name.equals(rhs.getName())
			&& weight.equals(rhs.getWeight())
			&& age.equals(rhs.getAge())) ? 1 : 0;
	}

	public String toString() {
		return "\n-zwierze: " + getKind() + "\n"
			+ "-waga: " + weight + "\n"
			+ "-wiek: " + age;
	}
}