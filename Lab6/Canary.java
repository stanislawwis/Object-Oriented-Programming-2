public class Canary extends Animal implements PlantEater, EggLayer {
	public Canary(String _name) {
		super(_name, 0, 0);
	}

	public String getKind() {
		return "kanarek";
	}

	public String eaterKind() {
		return getKind();
	}

	public String layerKind() {
		return getKind();
	}
}