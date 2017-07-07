/**
 * 
 */
package com.uday.java_8_features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author udaybhanuprasad
 *
 */
public class IntermediatoryAndFinal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		Consumer<String> c1 = System.out::println;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");
		List<String> result = new ArrayList<>();
		
		stream.peek(c1).filter(p2.or(p3)).peek(result::add); 
		System.out.println("DONE!");
		System.out.println("size of list: "+ result.size());
		
		stream = Stream.of("one", "two", "three", "four", "five");
		stream.peek(c1).filter(p2.or(p3)).forEach(result::add); 
		System.out.println("DONE!");
		System.out.println("size of list: "+ result.size());
	}

}
