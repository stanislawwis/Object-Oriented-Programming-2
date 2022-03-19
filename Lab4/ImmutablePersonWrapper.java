public class ImmutablePersonWrapper {
	private final ImmutablePerson wrappedPerson;

	ImmutablePersonWrapper(ImmutablePerson _wrappedPerson) {
		wrappedPerson = _wrappedPerson.clone();
	}

	void printInfoAboutPerson(String description) {
		System.out.println(wrappedPerson.getFirstName() + " is " + description);	
	}

	void printInfoAboutPerson(boolean isHavingGoodTime) {
		System.out.println(wrappedPerson.getFirstName() + " is having good time: " + isHavingGoodTime);
	}
}