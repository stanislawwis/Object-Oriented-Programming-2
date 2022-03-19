public class ColourPrinter {
	private enum Colour {
		RED (0, "czerwony"),
		GREEN (1, "zielony"),
		YELLOW (2, "zolty"),
		BLUE (3, "niebieski");
		private final int c;
		private final String p;
		Colour(int _c, String _p) { this.c = _c; this.p = _p; }
		public String getPolish() { return p; }
	}

	private static Colour[] ordered = {Colour.RED, Colour.GREEN, 
		Colour.YELLOW, Colour.BLUE};

	public static void printColours() {
		StringBuffer rv = new StringBuffer();
		for(Colour e : ordered) {
			rv.append("Kolor ").append(e.toString().toLowerCase())
				.append(" po polsku: ")
				.append(e.getPolish()).append("\n");
		}
		System.out.print(rv);
	}

	public static void printGetNameColours() {
		StringBuffer rv = new StringBuffer();
		for(Colour e : ordered) {
			rv.append(e.getPolish()).append("\n");
		}
		System.out.print(rv);
	}

	public static void printSaySomethingColours() {
		StringBuffer rv = new StringBuffer();
		for(Colour e : ordered) {
			rv.append("Kolor to ").append(e.getPolish()).append("\n");
		}
		System.out.print(rv);
	}
}