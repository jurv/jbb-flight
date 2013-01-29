<jsp:include page="header.jsp" />

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALCity"%>
<%@page import="fr.cpe.ha.jbbflight.models.Flight"%>
<%@page import="fr.cpe.ha.jbbflight.models.City"%>
<%
	List<Flight> flights = DALFlight.getInstance().GetAllFlights();
	List<City> cities = DALCity.getInstance().GetAllCities();
%>

<h1> Flight List </h1>
<table border="1">
	<tr>
		<th>Flight number</th>
		<th>From</th>
		<th>To</th>
		<th>Departure</th>
		<th>Arrival</th>
		<th>Price</th>
	</tr>
	<% 
	String fromCityName;
	String toCityName;
	
	for(Flight f : flights) {
		Long id = f.getFgt_id();
		Long fgt_leaving_from_id = f.getFgt_leaving_from_id();
		Long fgt_going_to_id = f.getFgt_going_to_id();
		Date fgt_date_departure = f.getFgt_date_departure();
		Date fgt_date_arrival = f.getFgt_date_arrival();
		double fgt_price = f.getFgt_price();
		
		fromCityName = DALCity.getInstance().GetCityById(f.getFgt_leaving_from_id()).getCty_label();
		toCityName   = DALCity.getInstance().GetCityById(f.getFgt_going_to_id()).getCty_label();
		
// 		"fgt_total_seats" ;
// 		"fgt_reserved_seats" ;
// 		"fgt_is_deleted" ;
	%>
	<tr>
		<td><%= id %></td>
		<td><%= fromCityName %></td>
		<td><%= toCityName %></td>
		<td><%= fgt_date_departure %></td>
		<td><%= fgt_date_arrival %></td>
		<td><%= fgt_price %></td>
	</tr>
	<% } %>
</table>

<jsp:include page="footer.jsp" />