package fr.cpe.ha.jbbflight.cron;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;

import fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight;
import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser_to_FlightSearch;
import fr.cpe.ha.jbbflight.models.User_to_FlightSearch;

/**
 * This controllers handles cron tasks for the FlightSearch objets.
 * 
 * @author Benjamin Chastanier
 *
 */
public class FlightSearchCronController extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		// Default, there is only one method in this servlet, 
		cleanOldValues();
	}

	/**
	 * Allows to delete all requests search older than 2 minutes.
	 * @throws ParseException 
	 */
	private void cleanOldValues() throws ParseException {
		
		// Get date for now - 2 minutes
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd/MM/yyyy");
		Calendar now = new GregorianCalendar();
		now.add(Calendar.MINUTE, -2);
		Date date = sdf.parse(now.toString()); 
		
		// Get all Flight search older than 2 minutes
		ArrayList<FilterPredicate> filters = new ArrayList<FilterPredicate>();
		filters.add(new FilterPredicate(User_to_FlightSearch.USER_TO_FLIGHTSEARCH_DATE, FilterOperator.GREATER_THAN_OR_EQUAL, date));
		ArrayList<User_to_FlightSearch> fs = new ArrayList<User_to_FlightSearch>(DALUser_to_FlightSearch.getInstance().GetAllUser_to_FlightSearchs(filters));
	
		// Delete all this search
		for(User_to_FlightSearch utf : fs)
			DALUser_to_FlightSearch.getInstance().RealRemoveUser_to_FlightSearch(utf);
	}
}
