import java.util.function.BinaryOperator;

public class PersonPrinter {
	public static BinaryOperator<Integer> sum = 
		(Integer a, Integer b) -> a+b;
	public static BinaryOperator<Integer> multiply = 
		(Integer a, Integer b) -> a*b;

	public static void print(Person... persons) {
		for(Person person : persons) {
			System.out.print(person);
		}
		System.out.println();
	}

	public static void printOperation(Person lhs, Person rhs, 
		BinaryOperator<Integer> op) {
		System.out.println(op.apply(lhs.age(), rhs.age()));
	}

	public static void checkIfCanDrink(Person p) {
		if(p.age() < 18) {
				System.out.println(p + " cannot drink alcohol");
				throw new CannotDrinkException("Catch Exception");
			}
			else {
				System.out.println("Can drink");
			}
	}

	public static void checkIfCanDrinkWithExceptionCatch(Person p) {
		try {
			checkIfCanDrink(p);
		}
		catch(CannotDrinkException e) {
			System.out.println(e.getMessage());
		}
	}
}