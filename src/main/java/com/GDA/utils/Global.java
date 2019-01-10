package main.java.com.GDA.utils;



import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Global {

	public static int  returnPeriodBetweenTwoDates(Date dateStart, Date dateEnd) {
		
		
		
		Duration period = Duration.between(LocalDate.of(dateStart.getYear(), dateStart.getMonth(), dateStart.getDay()),LocalDate.of(dateEnd.getYear(), dateEnd.getMonth(), dateEnd.getDay());
		System.out.println(period.toDays());
		return (int) period.toDays();
		
	}
}
