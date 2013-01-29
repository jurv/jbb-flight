<h1> Change password </h1>
<p>
	Choose a new password for your profile.
</p>
<form id="new_user_form" method="POST">
	<label for="usr_password">New Password *</label>
	<input id="usr_password" name="usr_password" type="password" value="" required /> <br/>
	
	<label for="usr_re_password">Re New Password *</label>
	<input id="usr_re_password" name="usr_re_password" type="password" value="" required /> <br/>
	
	<input id="usr_id" name="usr_id" type="text" hidden="hidden" />
	
	<input type="reset" value="Cancel" />
	<input type="submit" value="Save" />
</form>
<% if( request.getAttribute( "error-message" ) != null) { %>
<span style="color : red;">
	<%= request.getAttribute( "error-message" ) %>
</span>
<% } %>