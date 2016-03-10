/**
 * 
 */
package org.uday.inheritence.bank;

/**
 * @author bexadmin
 *
 */
public interface Account {
	public abstract double calculateInterest(double amount);
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
}
