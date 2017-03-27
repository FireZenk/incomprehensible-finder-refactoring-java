package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Pair find(AgeAffinity ageAffinity) {
		List<Pair> candidates = new ArrayList<Pair>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Pair r;
				if (people.get(i).birthDate().getTime() < people.get(j).birthDate().getTime()) {
					r = new Pair(people.get(i), people.get(j));
				} else {
					r = new Pair(people.get(j), people.get(i));
				}
				r.ageDifference = r.getPersonTwo().time() - r.getPersonOne().time();
				candidates.add(r);
			}
		}

		if (candidates.size() < 1) {
			return new Pair(null, null);
		}

		Pair answer = candidates.get(0);

		for (Pair result : candidates) {
			switch (ageAffinity) {
				case Closest:
					if (result.ageDifference < answer.ageDifference) {
						answer = result;
					}
					break;

				case Furthest:
					if (result.ageDifference > answer.ageDifference) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
