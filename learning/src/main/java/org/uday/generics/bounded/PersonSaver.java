/**
 * 
 */
package org.uday.generics.bounded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import org.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class PersonSaver {
	private final RandomAccessFile file;
	/**
	 * 
	 */
	public PersonSaver(final File file) throws FileNotFoundException{
		this.file = new RandomAccessFile(file, "rw");
	}
	
	public void save(Person person) throws IOException{
		file.writeUTF(person.getClass().getName());
		file.writeUTF(person.getFirstName());
		file.writeInt(person.getAge());
	}
	
	public void saveAll(Person[] persons) throws IOException{
		for(Person person: persons){
			save(person);
		}
	}
	
	public void savePersonList(List<Person> persons) throws IOException{
		for(Person person: persons){
			save(person);
		}
	}
	
	//use ? extends person for something like parameter on a method where you want to have that additional flexibility, but you dont need
	//all those type parameters lying around cluttering your code. 
	public void saveAnyList(List<? extends Person> persons) throws IOException{
		for(Person person: persons){
			save(person);
		}
	}
	
	public <T extends Person> void saveAnyTList(List<T> persons) throws IOException{
		for(Person person: persons){
			save(person);
		}
	}
	
	//use T extends Person when you want to declare a class and you want to restrict it and refer to that type elsewhere in your code.
	static class PersonHolder<T extends Person>{
		T get(){
			return null;
		}
	}

}
