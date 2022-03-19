

public class Email {
	private final String message;
	private final Employee sender;
	private final Employee receiver;

	public Email(Employee from, Employee to, String _message) {
		sender = from;
		receiver = to;
		message = _message;
	}

	public String getMessage() { 
		return message;
	}

	public Employee getFrom() { 
		return sender; 
	}

	public Employee getTo() { 
		return receiver; 
	}
}