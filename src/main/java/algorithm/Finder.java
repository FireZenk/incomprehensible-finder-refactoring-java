package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Pair find(AgeOrder ageOrder) {
		List<Pair> tr = new ArrayList<Pair>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Pair r = new Pair();
				if (people.get(i).birthDate().getTime() < people.get(j).birthDate().getTime()) {
					r.personOne = people.get(i);
					r.personTwo = people.get(j);
				} else {
					r.personOne = people.get(j);
					r.personTwo = people.get(i);
				}
				r.diff = r.personTwo.birthDate().getTime() - r.personOne.birthDate().getTime();
				tr.add(r);
			}
		}

		if (tr.size() < 1) {
			return new Pair();
		}

		Pair answer = tr.get(0);
		for (Pair result : tr) {
			switch (ageOrder) {
				case One :
					if (result.diff < answer.diff) {
						answer = result;
					}
					break;

				case Two :
					if (result.diff > answer.diff) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
