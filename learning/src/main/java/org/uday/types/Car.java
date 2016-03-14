/**
 * 
 */
package org.uday.types;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * @author bexadmin
 *
 */
public class Car implements Serializable{

	/**
	 * 
	 */
	public Car() {
		
	}
	
	static final long serialVersionUID = 1L;
	private String color = "Red";
	//Check the CarTest.java for the effect of transient variable output
	transient Date soldDate = new Date(System.currentTimeMillis());
	private String brandName = "Nissan";
	private String model = "Altima";
	private String year = "2015";
	
	public String toString(){
		return "Car Make & Model: "+ brandName + " " + model + " " + year + " Color: " + color + " SoldDate: " + soldDate; 
	}
}
