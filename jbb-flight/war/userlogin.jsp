<jsp:include page="headerlogin.jsp" />


<form method="POST" id="loginform">
	<fieldset>
		<section>
			<label for="usr_login">Login</label>
			<div>
				<input id="usr_login" name="usr_login" type="text" value="" required/> <br/>
			</div>
		</section>
		<section>
			<label for="usr_password">Password</label>
			<div>
				<input id="usr_password" name="usr_password" type="password" value="" required/> <br/>
			</div>
		</section>
		<section>
			<div>
				<button class="fr submit">Login</button>
			</div>
		</section>
	</fieldset>
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

<jsp:include page="footer.jsp" />
	