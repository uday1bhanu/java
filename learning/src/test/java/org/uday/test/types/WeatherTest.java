package org.uday.test.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.uday.types.Weather;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class WeatherTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WeatherTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WeatherTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Map weatherMap = new HashMap(4);
    	for (Weather weather : Weather.getWeatherList()){
    		weatherMap.put(weather, "Season");
    		
    	}
    	
    	Set<Weather> keys = weatherMap.keySet();
    	for(Weather weather : keys){
    		System.out.println("Weather "+ weather.getSeason());
    	}
        assertTrue( true );
    }
}
