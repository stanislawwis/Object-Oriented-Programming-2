public class Parrot extends Animal implements PlantEater, EggLayer {
	public Parrot() {
		super("", 0, 0);
	}

	public String getKind() {
		return "papuga";
	}

	public String eaterKind() {
		return getKind();
	}

	public String layerKind() {
		return getKind();
	}
}