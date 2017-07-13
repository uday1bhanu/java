/**
 * 
 */
package org.uday.model;

/**
 * @author udaybhanuprasad
 *
 */
public class Employee extends Person {

	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param birthday
	 * @param emailAddress
	 */
	public Employee(String firstName, String lastName, int age, Sex gender, int birthday, String emailAddress) {
		super(firstName, lastName, age, gender, birthday, emailAddress);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [toString()=" + super.toString() + ", getGender()=" + getGender() + ", getEmailAddress()="
				+ getEmailAddress() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getAge()=" + getAge() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	/**
	 * 
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstNameArg
	 * @param lastNameArg
	 * @param birthdayArg
	 * @param genderArg
	 * @param emailArg
	 */
	public Employee(String firstNameArg, String lastNameArg, int birthdayArg, Sex genderArg, String emailArg) {
		super(firstNameArg, lastNameArg, birthdayArg, genderArg, emailArg);
		// TODO Auto-generated constructor stub
	}

}
