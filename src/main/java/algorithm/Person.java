package algorithm;

import java.util.Date;

public class Person {

	private final String name;
	private Date birthDate;

	public Person(String name) {
		this.name = name;
	}

	Date birthDate() {
		return birthDate;
	}

	long time() {
		return birthDate.getTime();
	}

	public Person withBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	@Override public String toString() {
		return "Name: " + name + ", birthDate: " + birthDate;
	}
}

