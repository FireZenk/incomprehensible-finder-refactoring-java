package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.Pair;
import algorithm.AgeAffinity;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	private Person sue = new Person("Sue")
			.withBirthDate(new Date(50, 0, 1));
	private Person greg = new Person("Greg")
			.withBirthDate(new Date(52, 5, 1));
	private Person sarah = new Person("Sarah")
			.withBirthDate(new Date(82, 0, 1));
	private Person mike = new Person("Mike")
			.withBirthDate(new Date(79, 0, 1));

	@Before public void setup() {}

	@Test public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> people = new ArrayList<Person>();
		Finder finder = new Finder(people);

		Pair result = finder.find(AgeAffinity.Closest);

		assertEquals(null, result.getPersonOne());
		assertEquals(null, result.getPersonTwo());
	}

	@Test public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);

		Finder finder = new Finder(people);

		Pair result = finder.find(AgeAffinity.Closest);

		log(result);

		assertEquals(null, result.getPersonOne());
		assertEquals(null, result.getPersonTwo());
	}

	@Test public void Returns_Closest_Two_For_Two_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(greg);

		Finder finder = new Finder(people);

		Pair result = finder.find(AgeAffinity.Closest);

		log(result);

		assertEquals(sue, result.getPersonOne());
		assertEquals(greg, result.getPersonTwo());
	}

	@Test public void Returns_Furthest_Two_For_Two_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(mike);
		people.add(greg);

		Finder finder = new Finder(people);

		Pair result = finder.find(AgeAffinity.Furthest);

		log(result);

		assertEquals(greg, result.getPersonOne());
		assertEquals(mike, result.getPersonTwo());
	}

	@Test public void Returns_Furthest_Two_For_Four_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(sarah);
		people.add(mike);
		people.add(greg);

		Finder finder = new Finder(people);

		Pair result = finder.find(AgeAffinity.Furthest);

		log(result);

		assertEquals(sue, result.getPersonOne());
		assertEquals(sarah, result.getPersonTwo());
	}

	@Test public void Returns_Closest_Two_For_Four_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(sarah);
		people.add(mike);
		people.add(greg);

		Finder finder = new Finder(people);

		Pair result = finder.find(AgeAffinity.Closest);

		log(result);

		assertEquals(sue, result.getPersonOne());
		assertEquals(greg, result.getPersonTwo());
	}

	private void log(Pair result) {
		System.out.println("(1) " + result.getPersonOne() + "\n(2) " + result.getPersonOne() + "\n");
	}
}
