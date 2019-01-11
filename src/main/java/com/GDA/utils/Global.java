package main.java.com.GDA.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;


public class Global {

	public static int  returnPeriodBetweenTwoDates(LocalDate dateStart, LocalDate dateEnd) {
		String date1 = dateStart.toString().substring(0, 10);
		LocalDate start = LocalDate.parse(date1);
		String date2 = dateEnd.toString().substring(0, 10);
		LocalDate end = LocalDate.parse(date2);
		System.out.println(end +   "       " + start);
		Period period = Period.between(LocalDate.of(start.getYear(), start.getMonth(), start.getDayOfYear()),LocalDate.of(end.getYear(), end.getMonth(), end.getDayOfMonth()));
		System.out.println(period.getDays());
		return (int) period.getDays();
		
	}
	
}
