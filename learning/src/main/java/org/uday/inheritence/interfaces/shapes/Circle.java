/**
 * 
 */
package org.uday.inheritence.interfaces.shapes;

/**
 * @author bexadmin
 *
 */
public class Circle implements Shape{

	/**
	 * 
	 */
	private CircleHelperImplementation circleHelperImplementation;
	
	public Circle(double radius) {
		circleHelperImplementation = new CircleHelperImplementation(radius);
	}

	public double area() {
		
		return circleHelperImplementation.area();
	}

}
