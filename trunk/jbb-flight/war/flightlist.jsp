<jsp:include page="header.jsp" />

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight"%>
<%@page import="fr.cpe.ha.jbbflight.models.Flight"%>
<%
	List<Flight> flights = DALFlight.getInstance().GetAllFlights();
%>

<h1> Flight List </h1>
<table>
	<tr>
		<th>Flight number</th>
		<th>From</th>
		<th>To</th>
		<th>Departure</th>
		<th>Arrival</th>
		<th>Price</th>
	</tr>
	<% for(Flight f : flights) {
		String id = f.getFgt_id();
		String fgt_leaving_from_id = f.getFgt_leaving_from_id();
		String fgt_going_to_id = f.getFgt_going_to_id();
		Date fgt_date_departure = f.getFgt_date_departure();
		Date fgt_date_arrival = f.getFgt_date_arrival();
		double fgt_price = f.getFgt_price();
// 		"fgt_total_seats" ;
// 		"fgt_reserved_seats" ;
// 		"fgt_is_deleted" ;
	%>
	<tr>
		<td><%= id %></td>
		<td><%= fgt_leaving_from_id %></td>
		<td><%= fgt_going_to_id %></td>
		<td><%= fgt_date_departure %></td>
		<td><%= fgt_date_arrival %></td>
		<td><%= fgt_price %></td>
	</tr>
	<% } %>
</table>

<jsp:include page="footer.jsp" />