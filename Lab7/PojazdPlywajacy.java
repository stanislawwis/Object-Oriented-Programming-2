public abstract class PojazdPlywajacy extends Pojazd {
	Boolean swimming = true;

	public PojazdPlywajacy(String _name) {
		super(_name);
	}

	public void plyn() {
		swimming = true;
		super.jedz();
	}

	public void jedz() {
		swimming = false;
		super.jedz();
	}

	public void stop() {
		if(!running)
			swimming = true;
		super.stop();
	}

	public String cantMoveString() {
		if(swimming)
			return cantSwimString();
		else 
			return cantRideString();
	}

	public String stopMovingString() {
		if(swimming)
			return stopSwimmingString();
		else 
			return stopRidingString();
	}

	public String startMovingString() {
		if(swimming)
			return startSwimmingString();
		else
			return startRidingString();
	}

	protected String stopSwimmingString() {
		return getKind() + " " + "przestaje plynac";
	}
	protected String stopRidingString() {
		return getKind() + " " + "przestaje jechac";
	}
	protected String startSwimmingString() {
		return getKind() + " " + "zaczyna plynac";
	}
	protected String startRidingString() {
		return getKind() + " " + "zaczyna jechac";
	}
	protected String cantSwimString() {
		return getKind() + " " + "nie moze plynac bo nie jest wlaczona";
	}
	protected String cantRideString() {
		return getKind() + " " + "nie moze jechac bo nie jest wlaczona";
	}
}