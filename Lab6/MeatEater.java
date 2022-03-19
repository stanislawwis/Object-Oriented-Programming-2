public interface MeatEater extends Eater {
	default public void eatMeat() {
		System.out.println(eaterKind().substring(0,1).toUpperCase() 
			+ eaterKind().substring(1) + " je mieso...");
	}
}