/**
 * 
 */
package org.uday.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.uday.model.Person;
import org.uday.model.Person.Sex;

/**
 * @author udaybhanuprasad
 *
 */
public class TypeInference {

	/**
	 * 
	 */
	public TypeInference() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person uday = new Person("Uday", "Kanagala", 29, Sex.MALE, 20, "uday-kanagala@test.com");
		Person test1 = new Person("test", "1", 25, Sex.FEMALE, 15, "test-1@test.com");
		Person test2 = new Person("test", "2", 35, Sex.MALE, 25, "test-2@test.com");
		
		List<Person> persons = new ArrayList<>();
		persons.add(uday);
		persons.add(test1);
		persons.add(test2);
		
		Map<Boolean, List<Person>> map =
		persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 30));
		System.out.println(map);
		
		Map<Boolean, Long> mapCount =
				persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 30, Collectors.counting()));
				System.out.println(mapCount);
	}

}
