/**
 * 
 */
package com.uday.java_8_features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author udaybhanuprasad
 *
 */
public class ComparatorLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		List<String> list = Arrays.asList("***", "**", "****", "*");
		Collections.sort(list, comparator);
		
		for(String s : list){
			System.out.println(s);
		}
		
	}

}
