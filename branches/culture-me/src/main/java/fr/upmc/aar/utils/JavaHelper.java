package fr.upmc.aar.utils;

import java.util.Date;

public class JavaHelper {
	
	public static Date stringToDate(String date, String separator)
	{
		String [] splitDate = date.split(separator);
		return new Date(Integer.parseInt(splitDate[2]),Integer.parseInt(splitDate[1]),Integer.parseInt(splitDate[0]));
	}

}
