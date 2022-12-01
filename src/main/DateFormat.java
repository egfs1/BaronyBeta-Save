package main;

import java.text.SimpleDateFormat;

public class DateFormat {
	public static String getDateFormat() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	    return sdfDate.format(Long.valueOf(System.currentTimeMillis()));
	  }
}
