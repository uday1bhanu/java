/**
 * 
 */
package com.uday.java_8_features;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author udaybhanuprasad
 *
 */
public class FirstPredicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		Consumer<String> c1 = System.out::println;
		Predicate<String> p1 = s -> s.length() > 3;
		
		stream.filter(p1).forEach(c1);
		
		stream = Stream.of("one", "two", "three", "four", "five");
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");
		stream.filter(p2.or(p3)).forEach(c1); 

	}

}
