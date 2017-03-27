package algorithm;

public enum AgeAffinity {
	Closest, Furthest;

	Pair compare(Pair first, Pair second) {
		switch (this) {
			case Closest:
				if (first.ageDifference < second.ageDifference) {
					return first;
				}
				break;

			case Furthest:
				if (first.ageDifference > second.ageDifference) {
					return first;
				}
				break;
		}
		return second;
	}
}
