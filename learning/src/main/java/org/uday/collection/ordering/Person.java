/**
 * 
 */
package org.uday.collection.ordering;

/**
 * @author bexadmin
 *
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable {
	private String firstName;
	private String lastName;
	private int age;

	public enum Sex {
		MALE, FEMALE
	}

	Sex gender;
	int birthday;
	String emailAddress;

	public Person(){
		
	}
	
	Person(String firstNameArg, String lastNameArg, int birthdayArg,
			Sex genderArg, String emailArg) {
		firstName = firstNameArg;
		lastName = lastNameArg;
		birthday = birthdayArg;
		gender = genderArg;
		emailAddress = emailArg;
	}

	public void printPerson() {
		System.out.println(firstName + ", " + lastName+ ", " + this.getAge());
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Object anotherPerson) throws ClassCastException {
		if (!(anotherPerson instanceof Person))
			throw new ClassCastException("A Person object expected.");
		int anotherPersonAge = ((Person) anotherPerson).getAge();
		return this.age - anotherPersonAge;
	}

	public static Comparator LastNameComparator = new Comparator() {
		public int compare(Object person, Object anotherPerson) {
			String lastName1 = ((Person) person).getLastName().toUpperCase();
			String firstName1 = ((Person) person).getFirstName().toUpperCase();
			String lastName2 = ((Person) anotherPerson).getLastName()
					.toUpperCase();
			String firstName2 = ((Person) anotherPerson).getFirstName()
					.toUpperCase();

			if (!(lastName1.equals(lastName2)))
				return lastName1.compareTo(lastName2);
			else
				return firstName1.compareTo(firstName2);
		}
	};

	public static Comparator FirstNameComparator = new Comparator() {
		public int compare(Object person, Object anotherPerson) {
			String lastName1 = ((Person) person).getLastName().toUpperCase();
			String firstName1 = ((Person) person).getFirstName().toUpperCase();
			String lastName2 = ((Person) anotherPerson).getLastName()
					.toUpperCase();
			String firstName2 = ((Person) anotherPerson).getFirstName()
					.toUpperCase();

			if (!(firstName1.equals(firstName2)))
				return firstName1.compareTo(firstName2);
			else
				return lastName1.compareTo(lastName2);
		}
	};
	
	public static int compareByAge(Person a, Person b) {
        return new Integer(a.age).compareTo(new Integer(b.age));
    }
 
    public static List<Person> createRoster() {
         
        List<Person> roster = new ArrayList<>();
        roster.add(
            new Person(
            "Fred",
            "ASken",
            56,
            Person.Sex.MALE,
            "fred@example.com"));
        roster.add(
            new Person(
            "Jane",
            "Johns",
            34,
            Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
            new Person(
            "George",
            "Gore",
            27,
            Person.Sex.MALE, "george@example.com"));
        roster.add(
            new Person(
            "Bob",
            "Bosen",
            54,
            Person.Sex.MALE, "bob@example.com"));
         
        return roster;
    }
}
