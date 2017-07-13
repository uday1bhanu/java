/**
 * 
 */
package org.uday.test.generics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uday.generics.SortedPair;

/**
 * @author udaybhanuprasad
 *
 */
public class SortedPairTest{

	@Test
	public void shouldRetainOrderOfOrderedPair(){
		SortedPair<Integer> pair = new SortedPair<>(1, 2);
		assertEquals(1, pair.getFirst().intValue());
		assertEquals(2, pair.getSecond().intValue());
	}
	
	@Test
	public void shouldRetainOrderOfMissOrderedPair(){
		SortedPair<Integer> pair = new SortedPair<>(2, 1);
		assertEquals(1, pair.getFirst().intValue());
		assertEquals(2, pair.getSecond().intValue());
	}

}
