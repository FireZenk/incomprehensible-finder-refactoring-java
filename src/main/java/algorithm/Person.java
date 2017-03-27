package algorithm;

import java.util.Date;

public class Person {

	private final String name;
	private final Date birthDate;

	public Person(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	Date birthDate() {
		return birthDate;
	}

	long time() {
		return birthDate.getTime();
	}

	@Override public String toString() {
		return "Name: " + name + ", birthDate: " + birthDate;
	}
}

