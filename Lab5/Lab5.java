public class Lab5 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		System.out.println("Konstrukcja i wyswietlanie");
		LinkedList l1 = new LinkedList(arr);
		l1.display();

		System.out.println("Usuniecie elementu poczatkowego");
		l1.remove();
		l1.display();

		System.out.println("Laczenie list");
		int[] arr2 = {6, 7, 8, 9};
		LinkedList l2 = new LinkedList(arr2);
		l1.merge(l2);
		l1.display();

		System.out.println("Sprawdzanie zawartosci");
		System.out.println("Lista zawiera 2? " + l1.contains(2));
		System.out.println("Lista zawiera 10? " + l1.contains(10));

		System.out.println("Czyszczenie listy");
		l1.clear();
		l1.display();

		System.out.println("Wszystko razem");
		LinkedList l3 = (new LinkedList(arr)).
			merge(l2).
			remove().
			remove().
			add(10);
		l3.display();
	}
}