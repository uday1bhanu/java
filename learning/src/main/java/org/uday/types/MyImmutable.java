/**
 * 
 */
package org.uday.types;

/**
 * @author bexadmin
 *
 */
public final class MyImmutable {

	/**
	 * 
	 */
	public final int[] array;
	public MyImmutable(int[] arr) {
		this.array = arr.clone(); 
		//defensive copy. By returning defensive copy, the caller cannot change this object.
		//check the ImmutableTest.java for demonstration.
	}
	
	public int[] getArray(){
		return array.clone(); //defensive copy.
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer("Numbers are: ");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i] + " ");
		}
		return sb.toString();
	}
}
