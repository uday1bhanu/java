/**
 * 
 */
package com.uday.java_8_features;

import java.util.Arrays;
import java.util.List;

/**
 * @author udaybhanuprasad
 *
 */
public class ReductionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 10, 10);
		Integer total = list.stream().reduce(0, (i1,i2) -> i1+i2);
		System.out.println("sum total: "+ total);
		total = list.stream().reduce(0, Integer::sum);
		System.out.println("sum total: "+ total);
		
		total = list.stream().reduce(1, (i1,i2) -> i1*i2);
		System.out.println("mul total: "+ total);
	}

}
