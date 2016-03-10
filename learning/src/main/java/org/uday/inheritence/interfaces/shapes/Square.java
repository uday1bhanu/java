/**
 * 
 */
package org.uday.inheritence.interfaces.shapes;

/**
 * @author bexadmin
 *
 */
public class Square implements Shape{

	/**
	 * 
	 */
	private double length;
	
	public Square(double length) {
		this.length = length;
	}

	public double area() {
		
		return length * length;
	}

}
