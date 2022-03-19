import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.ParseException;

public class ImmutablePerson {
	private final String fname;
	private final String lname;
	private final Date dob;

	public ImmutablePerson(String _fname, String _lname, Date _dob) {
		fname = new String(_fname);
		lname = new String(_lname);
		dob = (Date)_dob.clone();
	}

	public String getInformation() {
		return "Imie: " + fname + " nazwisko: " + lname +
			" data urodzenia: " + dob;
	}

	public Date getDateOfBirth() {
		return (Date)dob.clone();
	}

	public String getFirstName() {
		return new String(fname);
	}

	public String getLastName() {
		return new String(lname);
	}

	public ImmutablePerson clone() {
		return new ImmutablePerson(fname, lname, dob);
	}

	public boolean equals(ImmutablePerson other) {
		if(this == other) return true;
		else return false; 
	}
}