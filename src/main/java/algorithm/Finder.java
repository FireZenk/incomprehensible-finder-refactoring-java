package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Pair> find(AgeAffinity ageAffinity) {
		List<Pair> candidates = new ArrayList<>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Pair r;
				if (people.get(i).birthDate().getTime() < people.get(j).birthDate().getTime()) {
					r = new Pair(people.get(i), people.get(j));
				} else {
					r = new Pair(people.get(j), people.get(i));
				}
				candidates.add(r);
			}
		}

		return candidates.stream().reduce(ageAffinity::compare);
	}
}
