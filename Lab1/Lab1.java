import java.util.Scanner;

public class Lab1 {
	static Scanner scanner = new Scanner(System.in);
	static Double PI = 3.14;

	public static void main(String[] args) {
		System.out.print("Podaj promien: ");
		Double r = scanner.nextDouble();
		System.out.println("Pole powierzchni: " + (PI * r * r));
		System.out.println("Obwod okregu: " + (2 * PI * r));
	}
}