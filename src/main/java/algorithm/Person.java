package algorithm;

import java.util.Date;

public class Person {

	private String name;
	private Date birthDate;

	private Person(PersonBuilder personBuilder) {
		name = personBuilder.name;
		birthDate = personBuilder.birthDate;
	}

	public String name() {
		return name;
	}

	public Date birthDate() {
		return birthDate;
	}

	public static class PersonBuilder {

		private String name;
		private Date birthDate;

		public PersonBuilder name(String name) {
			this.name = name;
			return this;
		}

		public PersonBuilder birthDate(Date birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}
}

