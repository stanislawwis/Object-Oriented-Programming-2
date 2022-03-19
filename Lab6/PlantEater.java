public interface PlantEater extends Eater {
	default public void eatPlant() {
		System.out.println(eaterKind().substring(0,1).toUpperCase() 
			+ eaterKind().substring(1) + " je ziarna...");
	}
}