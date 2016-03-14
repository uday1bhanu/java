package org.uday.test.types;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.uday.types.Car;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CarTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CarTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CarTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Car car = new Car(); // The “Car” class implements a java.io.Serializable interface
    	FileOutputStream fos = null;
    	ObjectOutputStream out = null;
    	
    	FileInputStream fis = null;
    	ObjectInputStream ois = null;
		try {
			System.out.println(car.toString());
			fos = new FileOutputStream("car.txt");
			out = new ObjectOutputStream(fos);
			out.writeObject(car); // serialization mechanism happens here
	    	out.close();
	    	
	    	fis = new FileInputStream("car.txt");
	    	ois = new ObjectInputStream(fis);
	    	Car deserializedCar = (Car)ois.readObject();
	    	System.out.println(deserializedCar.toString());
	    	
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(fos != null)fos.close();
				if(out != null)out.close();
				if(fis != null)fis.close();
				if(ois != null)ois.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}catch (IOException e) {
				
				e.printStackTrace();
			}
		}
    	
        assertTrue( true );
    }
}
