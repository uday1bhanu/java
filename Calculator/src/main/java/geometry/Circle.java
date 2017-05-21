package geometry;

import algebra.BasicOperations;

public class Circle {
	public static double diameter(double radius){
		return BasicOperations.multiply(radius, 2);
	}
	
	public static double perimeter(double radius){
		return BasicOperations.multiply(BasicOperations.multiply(2, BasicOperations.pi),radius);
	}
}
