/**
 * 
 */
package org.uday.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.uday.model.Person;
import org.uday.model.Person.Sex;

/**
 * @author udaybhanuprasad
 *
 */
public class GenericsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person uday = new Person("Uday", "Kanagala", 29, Sex.MALE, 20, "uday-kanagala@test.com");
		Person test1 = new Person("test", "1", 25, Sex.FEMALE, 15, "test-1@test.com");
		Person test2 = new Person("test", "2", 35, Sex.MALE, 25, "test-2@test.com");
		
		List<Person> madMen = new ArrayList<>();
		madMen.add(uday);
		madMen.add(test1);
		madMen.add(test2);
		
		System.out.println(madMen);
		Collections.sort(madMen, new AgeComparator());
		System.out.println(madMen);
		Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
		System.out.println(madMen);
		
		Person lowest = min(madMen, new AgeComparator());
		System.out.println(lowest);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		Integer minNumber = min(numbers, Integer::compare);
		System.out.println(minNumber);
		
	}
	
	//generics at a method level
	public static <T> T min(List<T> list, final Comparator<T> comparator){
		T lowest = list.get(0);
		for(int i=1; i< list.size(); i++){
			final T element = list.get(i);
			if(comparator.compare(element, lowest) < 0){
				lowest = element;
			}
		}
		
		return lowest;
	}

}
