abstract public class Pojazd {
	protected Boolean running = false;
	protected Boolean moving = false;
	private final String name;

	public Pojazd(String _name) {
		name = _name;
	}

	public void start() {
		if(!running) {
			running = true;
			System.out.println(startString());
		}
		else {
			moving = true;
			System.out.println(startMovingString());
		}
	}
	public void stop() {
		if(running) {
			running = false;
			System.out.println(stopEngineString());
		}
		else if(moving) {
			moving = false;
			System.out.println(stopMovingString());
		}
		else {
			// do nothing
		}
	}
	public void jedz() {
		if(!running) {
			System.out.println(cantMoveString());
		}
		else {
			moving = true;
			System.out.println(startMovingString());
		}
	}
	protected String startString() {
		return getKind() + " " + getName() + " " + "uruchamia silnik";
	}
	protected String stopEngineString() {
		return getKind() + " " + getName() + " " + "zatrzymuje silnik";
	}
	protected String stopMovingString() {
		return getKind() + " " + "przestaje jechac";
	}
	protected String cantMoveString() {
		return getKind() + " " + "nie moze jechac bo nie jest wlaczony";
	}
	protected String startMovingString() {
		return getKind() + " " + "jedzie";
	}
	protected String getName() {
		return name;
	}
	abstract protected String getKind();
	public String toString() {
		return getKind();
	}
}