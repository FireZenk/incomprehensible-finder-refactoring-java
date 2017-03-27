package algorithm;

public class Pair {

	private final Person personOne;
	private final Person personTwo;
	long ageDifference;

	Pair(Person personOne, Person personTwo) {
		this.personOne = personOne;
		this.personTwo = personTwo;
	}

	Pair withAgeDifference(long ageDifference) {
		this.ageDifference = ageDifference;
		return this;
	}

	public Person getPersonOne() {
		return personOne;
	}

	public Person getPersonTwo() {
		return personTwo;
	}
}
