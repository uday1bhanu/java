/**
 * 
 */
package org.uday.inheritence.shapes;

/**
 * @author bexadmin
 *
 */
public class Circle extends Shape {

	/**
	 * 
	 */
	private double radius;
	private static final double PI = 3.14;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	/* (non-Javadoc)
	 * @see org.uday.inheritence.learning.Shape#area()
	 */
	@Override
	public double area() {
		
		return PI * radius * radius;
	}

}
