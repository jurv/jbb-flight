package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.cpe.ha.jbbflight.models.User;

public class Utils {

	/**
	 * Get a Date from a string.
	 * @return
	 */
	public static Date getDateFromString(String date, String format) {
		
		if(format.isEmpty())
			format = "dd/MM/yyyy";
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dateTemp = null;
		try {
			dateTemp = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateTemp;
	}
}
