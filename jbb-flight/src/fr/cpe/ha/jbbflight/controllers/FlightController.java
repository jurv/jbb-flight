package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import utils.Utils;

import fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight;
import fr.cpe.ha.jbbflight.models.Flight;

/**
 * Flights' Controller
 * @author Julien Rouvier
 */
public class FlightController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.newFlight(req, resp);
		}else if("view".equals(action)){
			this.viewFlight(req, resp);
		}else if("edit".equals(action)){
			this.editFlight(req, resp);
		}else if("list".equals(action)){
			this.listFlight(req, resp);
		}else if("search".equals(action)){
			this.searchFlight(req, resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.newFlight(req, resp);
		}else if("edit".equals(action)){
			this.editFlight(req, resp);
		}else if("search".equals(action)){
			this.searchFlight(req, resp);
		}
	}
	
	public void newFlight(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/flightnew.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void viewFlight(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/flightview.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void searchFlight(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/flightsearch.jsp");			
		
		List<String> params = Collections.list(req.getParameterNames());
		HashMap<String, String> paramsAndValues = new HashMap<String, String>();
		
		if(params.contains("fgt_date_departure")){
			List<FilterPredicate> filters = new ArrayList<FilterPredicate>();
			FilterPredicate filter;
			
			for(String param : params)
			{
				String value = req.getParameter(param);
				filter = null;

				if(value != null && value != "")
				{
					if(param.equals("fgt_date_arrival"))
					{
						Date d = Utils.getDateFromString(value, "dd/mm/YYYY");
						filter = new FilterPredicate("fgt_date_arrival", FilterOperator.GREATER_THAN_OR_EQUAL, d);
					}
					else if(param.equals("fgt_max_price"))
					{
						double p = Double.parseDouble(value);
						filter = new FilterPredicate("fgt_price", FilterOperator.LESS_THAN_OR_EQUAL, p);
					}
					else if(param.equals("fgt_going_to_id"))
					{
						int id = Integer.parseInt(value);
						filter = new FilterPredicate("fgt_going_to_id", FilterOperator.EQUAL, id);
					}
					else if(param.equals("fgt_leaving_from_id"))
					{
						int id = Integer.parseInt(value);
						filter = new FilterPredicate("fgt_leaving_from_id", FilterOperator.EQUAL, id);
					}
					else if(param.equals("fgt_date_departure"))
					{
						Date d = Utils.getDateFromString(value, "dd/mm/YYYY");
						filter = new FilterPredicate("fgt_date_departure", FilterOperator.GREATER_THAN_OR_EQUAL, d);
					}

					if(filter != null)
						filters.add(filter);
				}
			}
			
			DALFlight dalFlight = DALFlight.getInstance();
			List<Flight> flights = dalFlight.GetFlightWithParams(filters);
			
			req.setAttribute("flights", flights);
		}
		
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void editFlight(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/flightedit.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void listFlight(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/flightlist.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
}