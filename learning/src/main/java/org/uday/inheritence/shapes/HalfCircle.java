/**
 * 
 */
package org.uday.inheritence.shapes;

/**
 * @author bexadmin
 *
 */
public class HalfCircle extends Circle {

	/**
	 * @param radius
	 */
	public HalfCircle(double radius) {
		super(radius);
	}

	public double area(){
		return super.area()/2;
	}
}
