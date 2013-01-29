<%@page import="fr.cpe.ha.jbbflight.controllers.DataInsertion"%>
<%@page import="java.util.List"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALCity"%>
<%@page import="fr.cpe.ha.jbbflight.models.City"%>
<%
	DataInsertion di = new DataInsertion();
	di.clear();
	di.insert();

	List<City> cities = DALCity.getInstance().GetAllCities();
%>

<h1> New Flight Form </h1>
<form id="new_flight_form" method="POST">
	<label for="fgt_leaving_from_id">Departure city</label>
	<select id="fgt_leaving_from_id" name="fgt_leaving_from_id">
		<% for(City c : cities) {
			String id = c.getCty_id();
			String name = c.getCty_label();
		%>
			<option 
				value="<%= id %>">
				<%= name %>
			</option>
		<% } %>
		
	</select><br/>
	
	<label for="fgt_going_to_id">Arrival city</label>
	<select id="fgt_going_to_id" name="fgt_going_to_id">
		<% for(City c : cities) {
			String id = c.getCty_id();
			String name = c.getCty_label();
		%>
			<option 
				value="<%= id %>">
				<%= name %>
			</option>
		<% } %>
		
	</select><br/>
	
	<label for="fgt_date_departure">Departure Date</label>
	<input id="fgt_date_departure" name="fgt_date_departure" type="text" value=""/> <br/>
	
	<label for="fgt_date_arrival">Return Date</label>
	<input id="fgt_date_arrival" name="fgt_date_arrival" type="text" value=""/> <br/>
	
	<label for="fgt_price">Price</label>
	<input id="fgt_price" name="fgt_price" type="text" value=""/> <br/>
	
	<label for="fgt_total_seats">Total seats</label>
	<input id="fgt_total_seats" name="fgt_total_seats" type="text" value=""/> <br/>
	
	<input type="submit" value="Create this flight" />
</form>