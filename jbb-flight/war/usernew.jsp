<jsp:include page="header.jsp" />

<h1> Registration Form </h1>
<p>
	Register as a User.
</p>
<form id="new_user_form" method="POST">
	<fieldset>
		<section>
			<label for="usr_firstname">First Name *</label>
			<div>
				<input id="usr_firstname" name="usr_firstname" type="text" value="" required/> <br/>
			</div>
		</section>
		<section>
			<label for="usr_lastname">Last Name *</label>
			<div>
				<input id="usr_lastname" name="usr_lastname" type="text" value="" required/> <br/>
			</div>
		</section>
		<section>
			<label for="usr_birthdate">Birth Date *</label>
			<div>
				<input id="usr_birthdate" name="usr_birthdate" type="date" value="" required/> <br/>
			</div>
		</section>
		<section>
			<label for="usr_email">Email *</label>
			<div>
				<input id="usr_email" name="usr_email" type="text" value="" required/> <br/>
			</div>
		</section>	
		<section>
			<label for="usr_login">Login *</label>
			<div>
				<input id="usr_login" name="usr_login" type="text" value="" required/> <br/>
			</div>
		</section>
		<section>
			<button class="fr submit">Register</button>
		</section>
		<input id="usr_password" name="usr_password" type="hidden" value=""/>
        	<input id="usr_re_password" name="usr_re_password" type="hidden" value=""/>
	</fieldset>
</form>

<jsp:include page="footer.jsp" />
