/**
 * 
 */
package org.uday.inheritence.bank;

/**
 * @author bexadmin
 *
 */
public class AccountHelperImplementation implements AccountHelper{

	/**
	 * 
	 */
	public AccountHelperImplementation() {
		
	}

	public void deposit(double amount) {
		System.out.println("depositing " + amount);
		
	}

	public void withdraw(double amount) {
		System.out.println("withdrawing " + amount);
		
	}

}
