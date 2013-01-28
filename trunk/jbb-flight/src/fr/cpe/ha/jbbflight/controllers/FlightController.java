package fr.cpe.ha.jbbflight.controllers;

import java.util.List;

import fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight;
import fr.cpe.ha.jbbflight.models.Flight;

/**
 * Flights' Controller
 * @author Julien Rouvier
 */
public class FlightController {

	/**
	 * Return all flights
	 * @return List<Flight> All flights registered in the datastore
	 */
	public List<Flight> getFlights(){
		DALFlight dalFlight = DALFlight.getInstance();
		return dalFlight.GetAllFlights();
	}
	
	/**
	 * Return a flight
	 * @param idUser The id of the flight
	 * @return Flight The flight
	 */
	public Flight getFlight(int idFlight){
		DALFlight dalFlight = DALFlight.getInstance();
		return dalFlight.GetFlightById(idFlight);
	}
	
}