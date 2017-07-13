/**
 * 
 */
package org.uday.generics;

import java.util.Comparator;

/**
 * @author udaybhanuprasad
 *
 */
public class ReverseComparator<T> implements Comparator<T> {
	
	private final Comparator<T> delegateComparator;
	
	public ReverseComparator(Comparator<T> delegateComparator){
		this.delegateComparator = delegateComparator;
	}
	
	@Override
	public int compare(T left, T right) {
		
		return -1*delegateComparator.compare(left, right);
	}
	
}
