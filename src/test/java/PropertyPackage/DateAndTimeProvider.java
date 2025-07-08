package PropertyPackage;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTimeProvider {

	
	

	public static String getCurrentDateAndTime()
	{
		LocalDate date = LocalDate.now();
		
		LocalTime time = LocalTime.now();
		
		String value= "_"+date+"_"+time;
		
		return value;
		
	}
	
	public static void main(String[] args) {
		String value =getCurrentDateAndTime();
		System.out.println("Date and Time :" +value);
	}
	
}
