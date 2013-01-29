package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import fr.cpe.ha.jbbflight.dataaccesslayout.DALCity;
import fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight;
import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser;
import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser_to_FlightSearch;
import fr.cpe.ha.jbbflight.models.City;
import fr.cpe.ha.jbbflight.models.Flight;
import fr.cpe.ha.jbbflight.models.User;
import fr.cpe.ha.jbbflight.models.User_to_FlightSearch;

@SuppressWarnings("serial")
public class DatastoreManager extends HttpServlet {

	private static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	private static SimpleDateFormat sdf       = new SimpleDateFormat("dd/MM/yyyy");;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		try {
			DatastoreManager.recreate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/user");
	}
	
	public static void recreate() throws ParseException
	{
		clear();
		insert();
	}
	
	public static void clear()
	{
		Query mydeleteq = new Query();
		PreparedQuery pq = datastore.prepare(mydeleteq);
		for (Entity result : pq.asIterable()){
		    datastore.delete(result.getKey());
		}
	}
	
	public static void insert() throws ParseException
	{
		DALCity dalCity                = DALCity.getInstance();
		DALUser dalUser                = DALUser.getInstance();
		DALFlight dalFlight            = DALFlight.getInstance();
		DALUser_to_FlightSearch dalU2F = DALUser_to_FlightSearch.getInstance();
		
		City cty1 = new City();
		cty1.setCty_is_deleted(false);
		cty1.setCty_label("Lyon");
		dalCity.AddCity(cty1);
		
		City cty2 = new City();
		cty2.setCty_is_deleted(false);
		cty2.setCty_label("San Francisco");
		dalCity.AddCity(cty2);
		
		User usr1 = new User();
		usr1.setUsr_firstname("Benjamin");
		usr1.setUsr_lastname("Chastanier");
		usr1.setUsr_login("ben");
		usr1.setUsr_birthdate(sdf.parse("05/04/1990"));
		usr1.setUsr_email("benjamin.chastanier@gmail.com");
		usr1.setUsr_password("ben");
		usr1.setUsr_is_password_confirmed(true);
		usr1.setUsr_date_creation(new Date());
		usr1.setUsr_date_delete(null);
		usr1.setUsr_is_admin(true);
		usr1.setUsr_is_deleted(false);
		dalUser.AddUser(usr1);
		
		User usr2 = new User();
		usr2.setUsr_firstname("Baptiste");
		usr2.setUsr_lastname("Gaujal");
		usr2.setUsr_login("baddou");
		usr2.setUsr_birthdate(sdf.parse("18/08/1988"));
		usr2.setUsr_email("baptiste.gaujal@gmail.com");
		usr2.setUsr_password("baddou");
		usr2.setUsr_is_password_confirmed(true);
		usr2.setUsr_date_creation(new Date());
		usr2.setUsr_date_delete(null);
		usr2.setUsr_is_admin(false);
		usr2.setUsr_is_deleted(false);		
		dalUser.AddUser(usr2);
		
		User usr3 = new User();
		usr3.setUsr_firstname("Julien");
		usr3.setUsr_lastname("Rouvier");
		usr3.setUsr_login("ju");
		usr3.setUsr_birthdate(sdf.parse("16/10/1986"));
		usr3.setUsr_email("jul.rouvier@gmail.com");
		usr3.setUsr_password("ju");
		usr3.setUsr_is_password_confirmed(true);
		usr3.setUsr_date_creation(new Date());
		usr3.setUsr_date_delete(null);
		usr3.setUsr_is_admin(false);
		usr3.setUsr_is_deleted(false);
		dalUser.AddUser(usr3);
		
		Flight fgt1 = new Flight();
		fgt1.setFgt_date_arrival(sdf.parse("30/01/2013"));
		fgt1.setFgt_date_departure(sdf.parse("29/01/2013"));
		fgt1.setFgt_going_to_id(cty1.getCty_id());
		fgt1.setFgt_is_deleted(false);
		fgt1.setFgt_leaving_from_id(cty2.getCty_id());
		fgt1.setFgt_price(1000);
		fgt1.setFgt_reserved_seats(0);
		fgt1.setFgt_total_seats(300);
		dalFlight.AddFlight(fgt1);
		
		Flight fgt2 = new Flight();
		fgt2.setFgt_date_arrival(sdf.parse("10/02/2013"));
		fgt2.setFgt_date_departure(sdf.parse("10/02/2013"));
		fgt2.setFgt_going_to_id(cty2.getCty_id());
		fgt2.setFgt_is_deleted(false);
		fgt2.setFgt_leaving_from_id(cty1.getCty_id());
		fgt2.setFgt_price(1200);
		fgt2.setFgt_reserved_seats(0);
		fgt2.setFgt_total_seats(350);
		dalFlight.AddFlight(fgt2);
		
		User_to_FlightSearch utf21 = new User_to_FlightSearch();
		utf21.setUtf_date(new Date());
		utf21.setUtf_date_departure(sdf.parse("29/01/2013"));
		utf21.setUtf_going_to(cty1.getCty_id());
		utf21.setUtf_is_deleted(false);
		utf21.setUtf_leaving_from(cty2.getCty_id());
		utf21.setUtf_responses_count(10);
		dalU2F.AddUser_to_FlightSearch(utf21);
		
		User_to_FlightSearch utf2 = new User_to_FlightSearch();
		utf2.setUtf_date(new Date());
		utf2.setUtf_date_departure(sdf.parse("29/01/2013"));
		utf2.setUtf_going_to(cty1.getCty_id());
		utf2.setUtf_is_deleted(false);
		utf2.setUtf_leaving_from(cty2.getCty_id());
		utf2.setUtf_responses_count(10);
		dalU2F.AddUser_to_FlightSearch(utf2);
	}
}
