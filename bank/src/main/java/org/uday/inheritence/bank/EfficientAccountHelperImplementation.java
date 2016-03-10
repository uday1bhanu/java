/**
 * 
 */
package org.uday.inheritence.bank;

/**
 * @author bexadmin
 *
 */
public class EfficientAccountHelperImplementation implements AccountHelper{

	/**
	 * 
	 */
	public EfficientAccountHelperImplementation() {
		// TODO Auto-generated constructor stub
	}

	public void deposit(double amount) {
		System.out.println("efficient depositing " + amount);
		
	}

	public void withdraw(double amount) {
		System.out.println("efficient withdrawing " + amount);
		
	}

}
