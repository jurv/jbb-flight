<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight"%>
<%@page import="fr.cpe.ha.jbbflight.models.Flight"%>
<%
	//List<Flight> flights = DALFlight.getInstance().GetAllFlights();
%>

<h1> Flight Search </h1>

<form method="POST">
	<label for="fgt_leaving_from_id">Departure city</label>
	<input type="text" id="fgt_leaving_from_id" name="fgt_leaving_from_id"><br/>
	
	<label for="fgt_going_to_id">Arrival city</label>
	<input type="text" id="fgt_going_to_id" name="fgt_going_to_id"><br/>
	
	<label for="fgt_date_departure">Departure Date</label>
	<input id="fgt_date_departure" name="fgt_date_departure" type="text" value=""/> <br/>
	
	<label for="fgt_date_arrival">Return Date</label>
	<input id="fgt_date_arrival" name="fgt_date_arrival" type="text" value=""/> <br/>
	
	<label for="fgt_max_price">Maximum Price</label>
	<input id="fgt_max_price" name="fgt_max_price" type="text" value=""/> <br/>

	<input type="submit" value="Search" />
</form>

${search}

<table>
	<tr>
		<th>Flight number</th>
		<th>From</th>
		<th>To</th>
		<th>Departure</th>
		<th>Arrival</th>
		<th>Price</th>
	</tr>
</table>