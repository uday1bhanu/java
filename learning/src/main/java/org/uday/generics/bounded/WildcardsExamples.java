/**
 * 
 */
package org.uday.generics.bounded;

import java.util.ArrayList;
import java.util.List;

import org.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class WildcardsExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Upper Bounded List<? extends Cls>
		// Lower Bounded List<? super Cls>
		// Unbounded List<?> 
		
		//Unbounded example
		List<Object> objects = new ArrayList<>();
		objects.add(new Object());
		objects.add(new Person());
		
		//this would throw error
		/*
		List<?> objectsUnbounded = new ArrayList<>();
		objectsUnbounded.add(new Object());
		objectsUnbounded.add(new Person());
		*/
		
		//this would throw error as ? => ? extends Object => there is no actual object that you can never put in this list.
		//the only value safe to put in is null
				/*
				List<? extends Object> objectsUnbounded = new ArrayList<>();
				objectsUnbounded.add(new Object());
				objectsUnbounded.add(new Person());
				*/
		
		List<? super Object> objectsUnboundedSuper = new ArrayList<>();
		objectsUnboundedSuper.add(new Object());
		objectsUnboundedSuper.add(new Person());
	}
}
