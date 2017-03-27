package algorithm;

public class Pair {

	private final Person younger;
	private final Person older;
	final long ageDifference;

	Pair(Person younger, Person older) {
		this.younger = younger;
		this.older = older;
		this.ageDifference = younger != null && older != null
				? older.time() - younger.time() : 0;
	}

	public Person personOne() {
		return younger;
	}

	public Person personTwo() {
		return older;
	}
}
