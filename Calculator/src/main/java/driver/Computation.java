package driver;

import algebra.BasicOperations;
import algebra.Polynomial;
import geometry.Circle;

public class Computation {
	public static enum operations{addition,substraction, multiply, division, power, linear, parabola, sinx, cosx, diameter, perimeter};
	public operations operation;
	public double[] variables = new double[5];
	
	public Computation(operations operation, double[] variables){
		this.operation = operation;
		this.variables = variables;
	}
	
	public double doWork(){
		double result = 0;
		if(operation==operations.perimeter){
			result = Circle.perimeter(variables[0]);
		}
		else if(operation==operations.addition){
			result = BasicOperations.addition(variables[0], variables[1]);
		}
		else if(operation==operations.multiply){
			result = BasicOperations.multiply(variables[0], variables[1]);
		}
		else if(operation==operations.substraction){
			result = BasicOperations.substraction(variables[0], variables[1]);
		}
		else if (operation==operations.division) {
			result = BasicOperations.division(variables[0], variables[1]);
		}
		else if (operation==operations.linear){
			result = Polynomial.linear(variables[0], variables[1], variables[2]);
		}
		else if (operation==operations.parabola){
			result = Polynomial.parabola(variables[0], variables[1], variables[2], variables[3]);
		}
		
		return result;
	}
}
