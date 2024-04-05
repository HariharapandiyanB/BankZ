package com.bankz.helper;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.bankz.utilities.UtilityTasks;
import com.bankz.utilities.InvalidInputException;

public interface Supplement {

	public static ZonedDateTime getDateTimeInTheZone(ZoneId zone) throws InvalidInputException{
		UtilityTasks.checkNull(zone);
		return ZonedDateTime.now(zone);
	}
	
	public static LocalDateTime currentTimeAndDate() throws InvalidInputException{
		return LocalDateTime.now();
	}
	
	public static long currentTimeInMillis() {
		return System.currentTimeMillis();
	}
	
	public static String millisToActualTime(long timeInMillis) throws InvalidInputException{
		UtilityTasks.checkNull(timeInMillis);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timeInMillis));
	}
	
	public static long dateToLong(String date)throws InvalidInputException{
		UtilityTasks.checkNull(date);
		return LocalDate.parse(date).toEpochDay();
	}
	
	public static LocalDate longToDate(long date)throws InvalidInputException{
		UtilityTasks.checkNull(date);
		return LocalDate.ofEpochDay(date);
	}
}
