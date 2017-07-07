/**
 * 
 */
package com.uday.util;

import java.util.function.Function;

/**
 * @author udaybhanuprasad
 *
 */
public class Helper {
		public static Integer add1(Integer x) { return x + 1; }
		public static String concat1(String x) { return x + 1; }
		public static Function<Integer, Integer> adder(Integer x) {
		       return y -> x + y;
		    }
}
