/**
 * 
 */
package org.uday.generics;

import java.util.Comparator;

import org.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person left, Person right) {
		return Integer.compare(left.getAge(), right.getAge());
	}

}
