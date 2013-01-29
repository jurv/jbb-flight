
<h1> Login </h1>
<form id="login-form" method="POST">
	<label for="usr_login">Login</label>
	<input id="usr_login" name="usr_login" type="text" value="" required/> <br/>
	
	<label for="usr_password">Password</label>
	<input id="usr_password" name="usr_password" type="password" value="" required/> <br/>

	<input type="reset" value="Cancel" />
	<input type="submit" value="Login" />
</form>
<p>
	New to VoYage ? 
	<a href="/user?action=new"> Register Now ! :)</a>
</p>
<% if( request.getAttribute( "message" ) != null) { %>
<span>
	<%= request.getAttribute( "message" ) %>
</span>
<% } %>
<% if( request.getAttribute( "error-message" ) != null) { %>
<span style="color : red;">
	<%= request.getAttribute( "error-message" ) %>
</span>
<% } %>
	