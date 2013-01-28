<h1> Registration Form </h1>
<form id="new_user_form" method="POST">
	<label for="usr_firstname">First Name *</label>
	<input id="usr_firstname" name="usr_firstname" type="text" value="" required/> <br/>
	
	<label for="usr_lastname">Last Name *</label>
	<input id="usr_lastname" name="usr_lastname" type="text" value="" required/> <br/>
	
	<label for="usr_birthdate">Birth Date *</label>
	<input id="usr_birthdate" name="usr_birthdate" type="date" value="" required/> <br/>
	
	<label for="usr_email">Email *</label>
	<input id="usr_email" name="usr_email" type="text" value="" required/> <br/>
	
	<label for="usr_login">Login *</label>
	<input id="usr_login" name="usr_login" type="text" value="" required/> <br/>
	
	<label for="usr_password">Password *</label>
	<input id="usr_password" name="usr_password" type="password" value="" required /> <br/>
	
	<label for="usr_re_password">Re Password *</label>
	<input id="usr_re_password" name="usr_re_password" type="password" value="" required /> <br/>
	
	<input type="reset" value="Cancel" />
	<input type="submit" value="Register" />
</form>