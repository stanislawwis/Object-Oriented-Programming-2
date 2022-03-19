public class SamochodOsobowy extends Pojazd {
	public SamochodOsobowy(String _name) {
		super(_name);
	}

	protected String getKind() { 
		return "samochod";
	}

	public String toString() {
		return "samochodOsobowy";
	}
}