<jsp:include page="header.jsp" />

<h1> Change password </h1>
<p>
	Choose a new password for your profile.
</p>
<form id="new_user_form" method="POST">
	<fieldset>
	<section>
		<label for="usr_password">New Password *</label>
		<div>
			<input id="usr_password" name="usr_password" type="password" value="" required /> <br/>
		</div>
	</section>
	<section>
		<label for="usr_re_password">Re New Password *</label>
		<div>
			<input id="usr_re_password" name="usr_re_password" type="password" value="" required /> <br/>
		</div>
	</section>
	<section>
		<input id="usr_id" name="usr_id" type="text" hidden="hidden" />
	</section>
	<section>
		<div>
			<button class="fr submit">Login</button>
		</div>
	</section>
	</fieldset>
</form>
<% if( request.getAttribute( "error-message" ) != null) { %>
<span style="color : red;">
	<%= request.getAttribute( "error-message" ) %>
</span>
<% } %>

<jsp:include page="footer.jsp" />