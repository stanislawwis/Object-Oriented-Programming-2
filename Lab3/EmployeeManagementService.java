import java.util.ArrayList;

public class EmployeeManagementService {
	private ArrayList<Employee> employees = new ArrayList<>();

	public void addNewEmployee(Employee employee) {
		employees.add(employee);
		System.out.println("Employee added " + employee.getFirstName() + " " + employee.getLastName());
	}

	public void printAllEmployees() {
		for(Employee e : employees) {
			System.out.println("Employee: " + e.getFirstName() + " , " + e.getLastName());
		}
	}

	public void changeEmail(Employee e, String email) {
		Integer ind = employees.indexOf(e);
		if(ind == -1) {
			System.out.println("Nie ma takiego pracownika");
			return;
		}
		employees.get(ind).setEmail(email);
	}

	public void fireEmployee(Employee e) {
		employees.remove(e);
	}

	public void sendMailToAllEmployees(String message) {
		for(Employee e: employees) {
			e.receiveEmail(new Email(Employee.HQ, e, message));
		}
	}
}