/**
 * 
 */
package org.uday.types;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bexadmin
 *
 * class “Weather” is immutable, and only one instance of each “Weather” can be created. 
 * So, Weather class does not have to override equals() and hashCode() methods.
 */
public class Weather {

	/**
	 * 
	 */
	
	public enum Season {WINTER, SPRING, SUMMER, FALL}
	private final Season season;
	private static final List<Weather> listWeather = new ArrayList<Weather> ();
	private Weather (Season season) { this.season = season;}
	public Season getSeason () { return season;}
	static {
		for (Season season : Season.values()) {
			listWeather.add(new Weather(season));
		}
	}
	
	public static List<Weather> getWeatherList () { return listWeather; }
	public String toString(){ return season.toString();}

}
