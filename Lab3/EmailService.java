

public class EmailService {
	public void generateEmailForNewEmployee(Employee e, String department) {
		// Imie.Nazwisko@Department.com
		e.setEmail(e.getFirstName() +"." + e.getLastName() + "@" + department + ".com");
	}


	public void sendMail(Employee from, Employee to, String message) {
		to.receiveEmail(new Email(from, to, message));
	}
}