package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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