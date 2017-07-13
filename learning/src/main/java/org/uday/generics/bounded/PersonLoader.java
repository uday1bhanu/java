/**
 * 
 */
package org.uday.generics.bounded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class PersonLoader {
	private final RandomAccessFile file;
	/**
	 * 
	 */
	public PersonLoader(final File file) throws FileNotFoundException {
		this.file = new RandomAccessFile(file, "rw");
	}
	
	public Person load(){
		try{
			final String className = file.readUTF();
			final String personName = file.readUTF();
			final int age = file.readInt();
			//Unbounded. This is equivalent to specifying any object, but ? != object.
			final Class<?> personClass = Class.forName(className);
			final Constructor<?> constructor = personClass.getConstructor(String.class, Integer.class);
			return (Person)constructor.newInstance(personName, age);
		}
		catch(ClassNotFoundException | IOException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
			return null;
		}
	}
	
	//
	public void loadAll(final List<? extends Person> people) throws ClassNotFoundException{
		Person person;
		while((person = load()) != null){
			//the below code would fail if we have ? extends Person because we are loading all Persons(mix of partners & employees) and so it wouldnt be possible to add to sub class of Person
			//and the solution is to use ? super Person as below to specify people as super class of Person i.e) Object class so that mix of partners & employees can fit in.
			//people.add(person);
		}
	}
	
	public void loadAllType(final List<? super Person> people) throws ClassNotFoundException{
		Person person;
		while((person = load()) != null){
			people.add(person);
		}
	}

}
