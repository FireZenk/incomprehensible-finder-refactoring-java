package test;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import algorithm.Pair;
import algorithm.AgeAffinity;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	private Person sue = new Person("Sue", new Date(50, 0, 1));
	private Person greg = new Person("Greg", new Date(52, 5, 1));
	private Person sarah = new Person("Sarah", new Date(82, 0, 1));
	private Person mike = new Person("Mike", new Date(79, 0, 1));

	@Before public void setup() {}

	@Test public void Returns_Empty_Results_When_Given_Empty_List() {
		Finder finder = new Finder(new ArrayList<>());

		Optional<Pair> result = finder.find(AgeAffinity.Closest);

		assertEquals(null, result.personOne());
		assertEquals(null, result.personTwo());
	}

	@Test public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> people = initPeople(sue);

		Finder finder = new Finder(people);

		Optional<Pair> result = finder.find(AgeAffinity.Closest);

		log(result);

		assertEquals(null, result.personOne());
		assertEquals(null, result.personTwo());
	}

	@Test public void Returns_Closest_Two_For_Two_People() {
		List<Person> people = initPeople(sue, greg);

		Finder finder = new Finder(people);

		Optional<Pair> result = finder.find(AgeAffinity.Closest);

		log(result);

		assertEquals(sue, result.personOne());
		assertEquals(greg, result.personTwo());
	}

	@Test public void Returns_Furthest_Two_For_Two_People() {
		List<Person> people = initPeople(mike, greg);

		Finder finder = new Finder(people);

		Optional<Pair> result = finder.find(AgeAffinity.Furthest);

		log(result);

		assertEquals(greg, result.personOne());
		assertEquals(mike, result.personTwo());
	}

	@Test public void Returns_Furthest_Two_For_Four_People() {
		List<Person> people = initPeople(sue, sarah, mike, greg);

		Finder finder = new Finder(people);

		Optional<Pair> result = finder.find(AgeAffinity.Furthest);

		log(result);

		assertEquals(sue, result.personOne());
		assertEquals(sarah, result.personTwo());
	}

	@Test public void Returns_Closest_Two_For_Four_People() {
		List<Person> people = initPeople(sue, sarah, mike, greg);

		Finder finder = new Finder(people);

		Optional<Pair> result = finder.find(AgeAffinity.Closest);

		log(result);

		assertEquals(sue, result.personOne());
		assertEquals(greg, result.personTwo());
	}

	private List<Person> initPeople(Person... people) {
		List<Person> result = new ArrayList<>();
		Collections.addAll(result, people);
		return result;
	}

	private void log(Optional<Pair> optionalResult) {
		if (optionalResult.isPresent()) {
			System.out.println("(1) " + result.personOne() + "\n(2) " + result.personOne() + "\n");
		}
	}
}
