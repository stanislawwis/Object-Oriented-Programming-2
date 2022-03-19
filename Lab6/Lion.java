public class Lion extends Animal implements MeatEater {
	private String type;

	public Lion(String _name, Integer _weight, Integer _age, String _type) {
		super(_name, _weight, _age);
		type = _type;
	}

	public String toString() {
		return super.toString() + "\n-typ: " + type;
	}

	public String getKind() {
		return "lew";
	}

	public String getType() {
		return type;
	}

	public String eaterKind() {
		return getKind();
	}

	public Integer compare(Lion rhs) {
		return !(getName().equals(rhs.getName())
			&& getWeight().equals(rhs.getWeight())
			&& getAge().equals(rhs.getAge())
			&& getType().equals(rhs.getType())) ? 1 : 0;
	}
}