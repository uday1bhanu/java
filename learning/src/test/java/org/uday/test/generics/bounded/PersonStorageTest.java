package org.uday.test.generics.bounded;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uday.generics.bounded.PersonLoader;
import org.uday.generics.bounded.PersonSaver;
import org.uday.model.Employee;
import org.uday.model.Partner;
import org.uday.model.Person;
import org.uday.model.Person.Sex;

public class PersonStorageTest {

	private Partner uday = new Partner("Uday", "Kanagala", 29, Sex.MALE, 20, "uday-kanagala@test.com");
	private Partner test1 = new Partner("test", "1", 25, Sex.FEMALE, 15, "test-1@test.com");
	private Employee test2 = new Employee("test", "2", 35, Sex.MALE, 25, "test-2@test.com");
	
	private File file;
	private PersonSaver saver;
	private PersonLoader loader;
	
	
	@Test
	public void saveAndLoadsPerson() throws Exception{
		Person person = new Person("Bob", "D", 20, Sex.MALE, "bob@test.com");
		saver.save(person);
		
		assertEquals(person, loader.load());
		
		saver.save(uday);
		assertEquals(uday, loader.load());
		
		saver.save(test1);
		assertEquals(test1, loader.load());
		
		saver.save(test2);
		assertEquals(test2, loader.load());
	}
	
	@Test
	public void saveAndLoadsArraysOfPeople() throws Exception{
		Person[] persons = new Person[2];
		persons[0] = uday;
		persons[1] = test1;
		persons[2] = test2;
		
		saver.saveAll(persons); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
		
		Partner[] partners = new Partner[2];
		partners[0] = uday;
		partners[1] = test1;
		persons = partners; 
		saver.saveAll(persons); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
		
		//this would fail, as uday & test1 are partners. This would throw ArrayStoreException 
		Employee[] employees = new Employee[2];
		persons = employees;
		persons[0] = uday;
		persons[1] = test1;
		saver.saveAll(persons); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
	}
	
	@Test
	public void saveAndLoadsListOfPeople() throws Exception{
		List<Person> persons = new ArrayList<>();
		
		//this would fail, as uday & test1 are partners. This would throw ArrayStoreException 
		//Employee[] employees = new Employee[2];
		//persons = employees;
		persons.add(uday);
		persons.add(test1);
		saver.savePersonList(persons); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
		
		List<Partner> partners = new ArrayList<>();
		
		partners.add(uday);
		partners.add(test1);
		//the below statement would throw error as uday & test1 are partners. but the saveAllList takes a list of Person only.
		// we need a wild card specifies upper bound objects aswell 
		//saver.savePersonList(partners); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
	}
	
	@Test
	public void saveAndLoadsAnyListOfPeople() throws Exception{
		List<Person> persons = new ArrayList<>();
		
		//this would fail, as uday & test1 are partners. This would throw ArrayStoreException 
		//Employee[] employees = new Employee[2];
		//persons = employees;
		persons.add(uday);
		persons.add(test1);
		saver.savePersonList(persons); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
		
		List<Partner> partners = new ArrayList<>();
		
		partners.add(uday);
		partners.add(test1);
		//the below statement would not throw error as we use ? extends wildcard to accept any sub classes partners, emploees(uday & test1 are partners).
		// ? extends is a wild card that specifies upper bound objects. 
		saver.saveAnyList(partners); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
		
		//this also works!
		saver.saveAnyTList(partners); 
		assertEquals(uday, loader.load());
		assertEquals(test1, loader.load());
		assertEquals(test2, loader.load());
	}
	
	@Test
	public void loadsListOfPeople() throws Exception{
		saver.save(uday);
		saver.save(test1);
		
		List<Person> people = new ArrayList<>();
		loader.loadAll(people);
		
		assertEquals(uday, people.get(0));
		assertEquals(test1, people.get(1)); 
	}
	
	@Test
	public void loadsAnyListOfPeople() throws Exception{
		saver.save(uday);
		saver.save(test1);
		
		//? super Person Object is super class of Person 
		List<Object> people = new ArrayList<>();
		loader.loadAllType(people);
		
		assertEquals(uday, people.get(0));
		assertEquals(test1, people.get(1)); 
	}
	
}
