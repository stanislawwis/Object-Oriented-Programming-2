public interface EggLayer {
	public String layerKind();

	default public void createEgg() {
		System.out.println(layerKind().substring(0,1).toUpperCase() 
			+ layerKind().substring(1) + " znosi jajko...");
	}
}