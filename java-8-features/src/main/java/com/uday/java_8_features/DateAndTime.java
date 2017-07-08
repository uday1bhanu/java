/**
 * 
 */
package com.uday.java_8_features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.uday.model.Person;

/**
 * @author udaybhanuprasad
 *
 */
public class DateAndTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		//Duration -> diff between two Instants
		Instant starttime = Instant.now();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(DateAndTime.class.getResourceAsStream("people.txt")));
				Stream<String> stream = reader.lines();
				){
			stream.map(line -> {
				String[] s = line.split(" ");
				int year = Integer.parseInt(s[4]);
				Month month = Month.of(Integer.parseInt(s[5]));
				int day = Integer.parseInt(s[6]);
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim(), s[3].trim(), LocalDate.of(year, month, day));
				persons.add(p);
				return p;
			}).forEach(System.out::println);
		}
		catch(IOException e){
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		Instant endtime = Instant.now();
		System.out.println("Time taken to read and stream file: "+ Duration.between(starttime, endtime).toMillis());
		
		//Period -> diff between two LocalDates
		LocalDate lDate = LocalDate.of(2017, 07, 07);
		persons.stream().forEach(p -> {
			Period period = Period.between(p.getBirthDate(), lDate);
			 System.out.println(p.getName() + " was  born "+ period.get(ChronoUnit.YEARS) + " years and "+ period.get(ChronoUnit.MONTHS) + " months ago ["+
			p.getBirthDate().until(lDate, ChronoUnit.MONTHS)+"] months");
		});
		
		//Temporal Adjusters
		LocalDate lDateNow = LocalDate.now();
		LocalDate lNextSunday = lDateNow.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(lNextSunday);
		
		LocalDate fDayOfMonth = lDateNow.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(fDayOfMonth);
		
		//Instant iDate = Instant.now();
		//Instant iNextSunday = iDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		//System.out.println(iNextSunday);
		
		//LocalTime
		LocalTime lTimeNow = LocalTime.now();
		System.out.println(lTimeNow);
		LocalTime lTime = LocalTime.of(10, 20);
		System.out.println(lTime);
		LocalTime timeToBed = LocalTime.of(23, 0);
		System.out.println(timeToBed);
		LocalTime timeToWake = timeToBed.plusHours(8);
		System.out.println(timeToWake);
		
		//ZonedTime
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		allZoneIds.stream().sorted(String::compareTo).forEach(System.out::println);
		
		ZoneId ukTZ = ZoneId.of("Europe/London");
		System.out.println(ukTZ);
		
		ZonedDateTime estTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("US/Eastern"));
		System.out.println(estTime);
		ZonedDateTime mountainTime = ZonedDateTime.of(2017, 07, 8, 15, 33, 45, 0, ZoneId.of("US/Mountain"));
		System.out.println(mountainTime);
		ZonedDateTime nextMonth = mountainTime.plus(Period.ofMonths(1));
		System.out.println(nextMonth);
		ZonedDateTime nextMonthInPST = nextMonth.withZoneSameInstant(ZoneId.of("US/Pacific"));
		System.out.println(nextMonthInPST);
		
		//Date Formatting:
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMonthInPST));
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMonthInPST));
	}

}
