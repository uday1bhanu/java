/**
 * 
 */
package org.uday.types;

/**
 * @author bexadmin
 *
 */
public class EnumType {

	/**
	 * 
	 */
	public EnumType() {
		
	}
	
	public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	
	Day day;
    
    public EnumType(Day day) {
        this.day = day;
    }
    
    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
    
    public static void main(String[] args) {
    	EnumType firstDay = new EnumType(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumType thirdDay = new EnumType(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumType fifthDay = new EnumType(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumType sixthDay = new EnumType(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumType seventhDay = new EnumType(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }

}
