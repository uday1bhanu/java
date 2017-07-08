/**
 * 
 */
package com.uday.java_8_features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class CollectorsExample {

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
		
		stream = persons.stream();
		opt = 
		stream.filter(p -> p.getAge() > 26).max(Comparator.comparing(Person::getAge));
		System.out.println(opt);
		
		stream = persons.stream();
		Map<Integer, List<Person>> map =
		stream.collect(Collectors.groupingBy(Person::getAge));
		System.out.println(map);
		
		stream = persons.stream();
		Map<Integer, List<String>> mapS =
		stream.collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println(mapS);
		
		stream = persons.stream();
		Map<String, List<String>> mapCity =
		stream.collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println(mapCity);
		
		stream = persons.stream();
		Map<String, Map<String,List<String>>> mapState =
		stream.collect(Collectors.groupingBy(Person::getState, Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList()))));
		System.out.println(mapState);
	}

}
