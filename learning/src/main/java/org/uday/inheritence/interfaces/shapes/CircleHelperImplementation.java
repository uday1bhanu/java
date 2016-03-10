/**
 * 
 */
package org.uday.inheritence.interfaces.shapes;

/**
 * @author bexadmin
 *
 */
public class CircleHelperImplementation implements CircleHelper {

	/**
	 * 
	 */
	private double radius;
	private static final double PI = 3.14;
	public CircleHelperImplementation( double radius) {
		this.radius = radius;
	}

	public double area() {
		
		return PI * radius * radius;
	}

}
