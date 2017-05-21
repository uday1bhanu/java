package algebra;

import algebra.BasicOperations;
public class Polynomial {
	
	public static double linear(double slope, double x, double constant){
		return BasicOperations.addition(BasicOperations.multiply(slope, x), constant);
	}
	
	public static double parabola(double slope, double x, double polynomialOrder, double constant){
		return BasicOperations.addition(BasicOperations.multiply(slope, BasicOperations.power(x, polynomialOrder)), constant);
	}
	
}
