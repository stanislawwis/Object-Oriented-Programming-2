public class Elephant extends Animal implements PlantEater {
	public Elephant(String _name, Integer _weight, Integer _age) {
		super(_name, _weight, _age);
	}

	public String getKind() {
		return "slon";
	}

	public String eaterKind() {
		return getKind();
	}
}