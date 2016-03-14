package org.uday.test.types;

import org.uday.types.MyImmutable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ImmutableTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ImmutableTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ImmutableTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	int[] array = {1,2};
    	MyImmutable myImmutableRef = new MyImmutable(array) ;
    	System.out.println("Before constructing " + myImmutableRef);
    	array[1] = 5; // change (i.e. mutate) the element
    	System.out.println("After constructing " + myImmutableRef);
        assertTrue( true );
    }
}
