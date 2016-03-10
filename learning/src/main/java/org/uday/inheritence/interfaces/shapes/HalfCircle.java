/**
 * 
 */
package org.uday.inheritence.interfaces.shapes;

/**
 * @author bexadmin
 *
 */
public class HalfCircle implements Shape{

	/**
	 * 
	 */
	private CircleHelperImplementation circleHelperImplementation;
	public HalfCircle(double radius) {
		circleHelperImplementation = new CircleHelperImplementation(radius);
	}

	public double area() {
		
		return circleHelperImplementation.area()/2;
	}

}
