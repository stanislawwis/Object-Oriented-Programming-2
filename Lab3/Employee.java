

public class Employee {
	private String fname;
	private String lname;
	private Integer id;
	private String email;
	private Email lastMessage;

	public static Employee HQ = new Employee(-1, "HEAD", "QUARTERS", "HQ@HQ.com");

	public Employee(Integer _id, String _fname, String _lname) {
		fname = _fname;
		lname = _lname;
		id = _id;
	}

	public Employee(Integer _id, String _fname, String _lname, String _email) {
		this(_id, _fname, _lname);
		email = _email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) { 
		email = new String(_email);
	}

	public String getFirstName() { 
		return fname; 
	}
	
	public String getLastName() { 
		return lname; 
	}

	public Email getLastEmailMessage() {
		return lastMessage;
	}

	public void receiveEmail(Email message) {
		lastMessage = message;
	}
}