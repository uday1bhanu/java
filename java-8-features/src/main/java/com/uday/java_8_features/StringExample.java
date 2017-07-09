/**
 * 
 */
package com.uday.java_8_features;

import java.util.StringJoiner;

/**
 * @author udaybhanuprasad
 *
 */
public class StringExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner(", ", "{", "}"); // separator, prefix, postfix
		System.out.println(sj.toString());
		sj.add("one");
		System.out.println(sj.toString());
		sj.add("two").add("three");
		System.out.println(sj.toString());
		
		String [] numbers = {"one", "two", "three"};
		String n = String.join(", ", numbers);
		System.out.println(n);

	}

}
