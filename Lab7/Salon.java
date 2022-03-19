import java.util.ArrayList;
import java.util.List;

public class Salon {
	private final List<Pojazd> list;
	private final String name;

	public Salon(String _name) {
		name = _name;
		list = new ArrayList<>();
	}

	public Salon(Salon cp, String _name) {
		name = _name;
		list = new ArrayList<>();
		list.addAll(cp.getList());
	}

	public List getList() {
		return list;
	}

	public void dodajPojazd(Pojazd x) {
		list.add(x);
		System.out.println("Dodaje pojazd");
	}

	public void usunPojazd(Pojazd x) {
		list.remove(x);
		System.out.println("Usuwam " + x + " z " + name);
	}

	public Boolean zawieraPojazd(Pojazd x) {
		System.out.println(list.contains(x));
		return list.contains(x);
	}

	public void wypiszWszystkiePojazdy() {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + (i == list.size()-1 ? "" : ", "));
		}
		System.out.print("\n");
	}
}