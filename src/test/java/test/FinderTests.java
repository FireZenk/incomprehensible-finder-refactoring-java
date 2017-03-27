package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.F;
import algorithm.FT;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	private Person sue;
	private Person greg;
	private Person sarah;
	private Person mike;

	@Before public void setup() {
		sue = new Person.PersonBuilder()
				.name("Sue")
				.birthDate(new Date(50, 0, 1))
				.build();

		greg = new Person.PersonBuilder()
				.name("Greg")
				.birthDate(new Date(52, 5, 1))
				.build();

		sarah = new Person.PersonBuilder()
				.name("Sarah")
				.birthDate(new Date(82, 0, 1))
				.build();

		mike = new Person.PersonBuilder()
				.name("Mike")
				.birthDate(new Date(79, 0, 1))
				.build();
	}

	@Test public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> people = new ArrayList<Person>();
		Finder finder = new Finder(people);

		F result = finder.Find(FT.One);
		assertEquals(null, result.P1);

		assertEquals(null, result.P2);
	}

	@Test public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);

		Finder finder = new Finder(people);

		F result = finder.Find(FT.One);

		assertEquals(null, result.P1);
		assertEquals(null, result.P2);
	}

	@Test public void Returns_Closest_Two_For_Two_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(greg);

		Finder finder = new Finder(people);

		F result = finder.Find(FT.One);

		assertEquals(sue, result.P1);
		assertEquals(greg, result.P2);
	}

	@Test public void Returns_Furthest_Two_For_Two_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(mike);
		people.add(greg);

		Finder finder = new Finder(people);

		F result = finder.Find(FT.Two);

		assertEquals(greg, result.P1);
		assertEquals(mike, result.P2);
	}

	@Test public void Returns_Furthest_Two_For_Four_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(sarah);
		people.add(mike);
		people.add(greg);

		Finder finder = new Finder(people);

		F result = finder.Find(FT.Two);

		assertEquals(sue, result.P1);
		assertEquals(sarah, result.P2);
	}

	@Test public void Returns_Closest_Two_For_Four_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(sarah);
		people.add(mike);
		people.add(greg);

		Finder finder = new Finder(people);

		F result = finder.Find(FT.One);

		assertEquals(sue, result.P1);
		assertEquals(greg, result.P2);
	}

}
