<jsp:include page="header.jsp" />

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALFlight"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALCity"%>
<%@page import="fr.cpe.ha.jbbflight.models.Flight"%>
<%@page import="fr.cpe.ha.jbbflight.models.City"%>
<%@page import="fr.cpe.ha.jbbflight.controllers.DatastoreManager" %>
<%
	//DatastoreManager.recreate();
	List<City> cities = DALCity.getInstance().GetAllCities();
%>

<h1> Flight Search </h1>
<p>
	Fill fields to search flights.
</p>

<form method="POST">
	<fieldset>
		<section>
			<label for="fgt_leaving_from_id">Departure city</label>
			<div>
				<select id="fgt_leaving_from_id" name="fgt_leaving_from_id">
				<option value=""></option>
				<% for(City c : cities) {
					Long id = c.getCty_id();
					String name = c.getCty_label();
				%>
				<option 
					value="<%= id %>">
					<%= name %>
				</option>
				<% } %>
				</select>
			</div>
		</section>
		<section>
			<label for="fgt_going_to_id">Arrival city</label>
			<div>
			<select id="fgt_going_to_id" name="fgt_going_to_id">
				<option value=""></option>
				<% for(City c : cities) {
					Long id = c.getCty_id();
					String name = c.getCty_label();
				%>
					<option 
						value="<%= id %>">
						<%= name %>
					</option>
				<% } %>
				
			</select>
			</div>
		</section>
	
		<section>
			<label for="fgt_date_departure">Departure Date</label>
			<div>
				<input id="fgt_date_departure" name="fgt_date_departure" type="text" value=""/> <br/>
			</div>
		</section>
	
	<section>
		<label for="fgt_date_arrival">Arrival Date</label>
		<div>
			<input id="fgt_date_arrival" name="fgt_date_arrival" type="text" value=""/> <br/>
		</div>
	</section>
	
	<section>
		<label for="fgt_max_price">Maximum Price</label>
		<div>
			<input id="fgt_max_price" name="fgt_max_price" type="text" value=""/> <br/>
		</div>
	</section>
	
	<section>
		<div>
			<button class="fr submit">Search</button>
		</div>
	</section>
	
	</fieldset>
</form>


<table border="1" class='datable'>
	<tr>
		<th>Flight number</th>
		<th>From</th>
		<th>To</th>
		<th>Departure</th>
		<th>Arrival</th>
		<th>Price</th>
	</tr>
	
	<% 
		List<Flight> flights = (List<Flight>)request.getAttribute("flights");
		
		String fromCityName;
		String toCityName;
			
		if(flights != null && !flights.isEmpty()){
			for(Flight f : flights){
				fromCityName = DALCity.getInstance().GetCityById(f.getFgt_leaving_from_id()).getCty_label();
				toCityName   = DALCity.getInstance().GetCityById(f.getFgt_going_to_id()).getCty_label();
			%>
				<tr>
					<td><%= f.getFgt_id() %></td>
					<td><%= fromCityName %></td>
					<td><%= toCityName %></td>
					<td><%= f.getFgt_date_departure() %></td>
					<td><%= f.getFgt_date_arrival() %></td>
					<td><%= f.getFgt_price() %></td>
				</tr>
			<%
			}
		}else{
			%>
				<tr>
					<td colspan="6">No flights match your request</td>
				</tr>
			<%
		}
	%>
</table>
<jsp:include page="footer.jsp" />