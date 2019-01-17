package main.java.com.GDA.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import main.java.com.GDA.bean.User;


public class Global {

	public static int  returnPeriodBetweenTwoDates(LocalDate dateStart, LocalDate dateEnd) {
		String date1 = dateStart.toString().substring(0, 10);
		LocalDate start = LocalDate.parse(date1);
		String date2 = dateEnd.toString().substring(0, 10);
		LocalDate end = LocalDate.parse(date2);
		
		
		LocalDate varDate = dateStart;
		
		Period period = Period.between(LocalDate.of(start.getYear(), start.getMonth(), start.getDayOfMonth()),LocalDate.of(end.getYear(), end.getMonth(), end.getDayOfMonth()));
		System.out.println(period.getDays());
		int nbrOfWorkday = 1;
		for(int i = 0; i<(int) period.getDays(); i++) {
			varDate = varDate.plusDays(1);
			if (!(varDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
					varDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
		            ++nbrOfWorkday;
		        }
		}	
		return nbrOfWorkday;
	}
	
	public static int  returnDurationBetweenTwoDates(LocalDate dateStart, LocalDate dateEnd) {
		String date1 = dateStart.toString().substring(0, 10);
		LocalDate start = LocalDate.parse(date1);
		String date2 = dateEnd.toString().substring(0, 10);
		LocalDate end = LocalDate.parse(date2);
		
		
		LocalDate varDate = dateStart;
		
		Period period = Period.between(LocalDate.of(start.getYear(), start.getMonth(), start.getDayOfMonth()),LocalDate.of(end.getYear(), end.getMonth(), end.getDayOfMonth()));
		System.out.println(period.getDays());
		int nbrOfWorkday = 1;
		
		return nbrOfWorkday;
	}
	
}
