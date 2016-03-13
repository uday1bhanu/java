package org.uday.test.collection.ordering;

import java.util.Arrays;

import org.uday.collection.ordering.Person;
import org.uday.collection.ordering.PersonLastNameComparator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PersonTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PersonTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PersonTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Person[] persons = new Person[4];
        persons[0] = new Person();
        persons[0].setFirstName("Elvis");
        persons[0].setLastName("Goodyear");
        persons[0].setAge(56);

        persons[1] = new Person();
        persons[1].setFirstName("Stanley");
        persons[1].setLastName("Clark");
        persons[1].setAge(8);

        persons[2] = new Person();
        persons[2].setFirstName("Jane");
        persons[2].setLastName("Graff");
        persons[2].setAge(16);

        persons[3] = new Person();
        persons[3].setFirstName("Nancy");
        persons[3].setLastName("Goodyear");
        persons[3].setAge(8);

        System.out.println("Natural Order");

        for (int i=0; i<4; i++) {
          Person person = persons[i];
          String lastName = person.getLastName();
          String firstName = person.getFirstName();
          int age = person.getAge();
          System.out.println(lastName + ", " + firstName + ". Age:" + age);
        }

        Arrays.sort(persons, Person.LastNameComparator);
        System.out.println();
        System.out.println("Sorted by last name");

        for (int i=0; i<4; i++) {
          Person person = persons[i];
          String lastName = person.getLastName();
          String firstName = person.getFirstName();
          int age = person.getAge();
          System.out.println(lastName + ", " + firstName + ". Age:" + age);
        }

        Arrays.sort(persons, Person.FirstNameComparator);
        System.out.println();
        System.out.println("Sorted by first name");

        for (int i=0; i<4; i++) {
          Person person = persons[i];
          String lastName = person.getLastName();
          String firstName = person.getFirstName();
          int age = person.getAge();
          System.out.println(lastName + ", " + firstName + ". Age:" + age);
        }

        Arrays.sort(persons);
        System.out.println();
        System.out.println("Sorted by age");

        for (int i=0; i<4; i++) {
          Person person = persons[i];
          String lastName = person.getLastName();
          String firstName = person.getFirstName();
          int age = person.getAge();
          System.out.println(lastName + ", " + firstName + ". Age:" + age);
        }
        
        Arrays.sort(persons, new PersonLastNameComparator());
        System.out.println();
        System.out.println("Sorted by last name");

        for (int i=0; i<4; i++) {
          Person person = persons[i];
          String lastName = person.getLastName();
          String firstName = person.getFirstName();
          int age = person.getAge();
          System.out.println(lastName + ", " + firstName + ". Age:" + age);
        }
        
        assertTrue( true );
    }
}
