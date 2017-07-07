/**
 * 
 */
package com.uday.java_8_features;

import java.util.function.BinaryOperator;
import java.util.function.Function;

import com.uday.util.Helper;

/**
 * @author udaybhanuprasad
 *
 */
public class FunctionsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Function<Integer, Integer> add1 = x -> x+1;
		Function<String, String> concat1 = x -> x+1;
		Function<Integer,Integer> mul3 = x -> x * 3;
		
		Integer two = add1.apply(1);
		String ans = concat1.apply("0+1=");
		System.out.println(two);
		System.out.println(ans);
		
		add1 = Helper::add1;
		concat1 = Helper::concat1;
		two = add1.apply(1);
		ans = concat1.apply("0+1=");
		System.out.println(two);
		System.out.println(ans);
		
		//function of function
		Function<Integer, Function<Integer,Integer>> makeAdder = x -> y -> x + y;
		
		Function<Integer, Integer> add10 = makeAdder.apply(10);
		Integer result = add10.apply(5);
		System.out.println(result);
		
		Function<Integer, Function<Integer,Integer>> adder = Helper::adder;
		Function<Integer, Integer> add4 = adder.apply(4);
		result = add4.apply(5);
		System.out.println(result);
		
		//functions that receive functions as input
		Integer t = 10;
		result = mul3.apply(add1.apply(t));
		System.out.println(result);
		
		//(f,g) -> x -> g( f(x) )
		//h -> g o f
		//approach1
		BinaryOperator<Integer> sum = (a,b) -> a + b;
		result = sum.apply(1,2);
		System.out.println(result);
		
		BinaryOperator<Function<Integer,Integer>> compose = (f,g) -> x -> g.apply(f.apply(x));
		Function<Integer,Integer> h = compose.apply(add1,mul3);
		result = h.apply(10);
		System.out.println(result);
		
		//approach2
		h = mul3.compose(add1);
		result = h.apply(10);
		
	}

}
