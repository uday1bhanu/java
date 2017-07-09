/**
 * 
 */
package com.uday.java_8_features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class ComparatorExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));
				Stream<String> stream = reader.lines();
				)
		{
			stream.map(l -> {
				String[] s = l.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim(), s[3].trim(), null);
				persons.add(p);
				return p;
			}).forEach(System.out::println);
		}
		catch(IOException e){
			System.out.println(e);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		Stream<Person> stream = persons.stream();
		Optional<Person> opt = 
		stream.filter(p -> p.getAge() > 26).min(Comparator.comparing(Person::getAge));
		System.out.println(opt);
		
		//chaining comparators
		Comparator<Person> comparator = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
		persons.stream().sorted(comparator).forEach(System.out::println);
		
		//reverse comparator
		persons.stream().sorted(comparator.reversed()).forEach(System.out::println);
		
		List<String> numbers = Arrays.asList("one", "two", "three", "four");
		numbers.sort(Comparator.naturalOrder());
		System.out.println(numbers.stream().collect(Collectors.joining(", ")));
		
		numbers.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
		numbers.sort(Comparator.nullsLast(Comparator.naturalOrder()));
	} 

}
