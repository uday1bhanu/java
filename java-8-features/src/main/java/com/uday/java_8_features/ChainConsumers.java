/**
 * 
 */
package com.uday.java_8_features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author udaybhanuprasad
 *
 */
public class ChainConsumers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
		List<String> result = new ArrayList<>();
		
		//Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = result::add;
		strings.forEach(c1.andThen(c2));
		//strings.forEach(c2);
		Stream.of("size of result:" + result.size()).forEach(c1);
		
		
	}

}
