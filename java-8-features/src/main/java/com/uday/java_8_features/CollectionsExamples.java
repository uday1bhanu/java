/**
 * 
 */
package com.uday.java_8_features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class CollectionsExamples {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new methods on collections API
		// stream(), parallelStream(), spliterator()
		
		//new methods on Iterable
		//forEach()
		List<String> numbers = Arrays.asList("one", "two", "three", "four");
		numbers.forEach(System.out::println);
		
		//new methods on Collection
		//removeIf()
		Collection<String> list = new ArrayList<>(numbers);
		boolean b = list.removeIf( s -> s.length() > 4);
		String n = list.stream().collect(Collectors.joining(","));
		System.out.println(n);
		 
		//new methods on List
		//replaceALL(), sort()
		numbers.replaceAll(String::toUpperCase);
		System.out.println(numbers.stream().collect(Collectors.joining(", ")));
		
		numbers.sort(Comparator.naturalOrder());
		System.out.println(numbers.stream().collect(Collectors.joining(", ")));
		
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
		
		//Map enhancements
		//map.getOrDefault(), map.putIfAbsent(key, person), map.replace(key, oldPerson, newPerson), map.replaceAll((key,oldPerson)-> newPerson), map.remove(key, person)
		//compute(key, person, (key,oldPerson)->newPerson), computeIfPresent(key, person, (key,oldPerson)->newPerson), computeIfAbsent(key, key->newPerson)
		//merge (key, person, (key,oldPerson)->newPerson)
		List<Person> list1 = persons.subList(0, 2);
		List<Person> list2 = persons.subList(2, persons.size());
		
		Map<Integer, List<Person>> map1 = mapByAge(list1);
		Map<Integer, List<Person>> map2 = mapByAge(list2);
		
		map1.forEach((age, l) -> System.out.println("age["+age+"]"+" list["+l+"]"));
		map2.forEach((age, l) -> System.out.println("age["+age+"]"+" list["+l+"]"));
		
		//merge()
		map2.entrySet().stream()
			.forEach(entry -> map1.merge(entry.getKey(), entry.getValue(), (l1,l2) -> {
				l1.addAll(l2);
				return l1;
				}));
		System.out.println("Map1 merged");
		map1.forEach((age, l) -> {
			System.out.println("age["+age+"]"+" list["+l+"]");
		});
		
		//biMap
		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();
		persons.forEach(person -> biMap.computeIfAbsent(person.getAge(), HashMap::new).merge(person.getCity(), new ArrayList<>(Arrays.asList(person)), (l1, l2) -> {
			l1.addAll(l2);
			return l1;
		}));
		biMap.forEach((age, m) -> System.out.println(age +"->"+ m));
	}
	
	public static Map<Integer, List<Person>> mapByAge(List<Person> persons){
		Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		return personsByAge;
	}
}
