/**
 * 
 */
package org.uday.inheritence.shapes;

/**
 * @author bexadmin
 *
 */
public class Square extends Shape {

	/**
	 * 
	 */
	private double length;
	
	public Square(double length) {
		this.length = length;
	}

	/* (non-Javadoc)
	 * @see org.uday.inheritence.learning.Shape#area()
	 */
	@Override
	public double area() {
		
		return length * length;
	}

}
