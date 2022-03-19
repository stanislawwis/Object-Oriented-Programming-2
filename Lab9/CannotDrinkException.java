import java.lang.Exception;
import java.lang.RuntimeException;

public class CannotDrinkException extends RuntimeException {
	public CannotDrinkException(String message) {
		super(message);
	}
}