<!-- View page 7 -->
<%@page import="fr.cpe.ha.jbbflight.controllers.DatastoreManager"%>
<%@page import="java.util.List"%>
<%@page import="fr.cpe.ha.jbbflight.dataaccesslayout.DALUser"%>
<%@page import="fr.cpe.ha.jbbflight.models.User"%>
<%

	//DatastoreManager.insert();
	List<User> users = DALUser.getInstance().GetAllUsers();
%>
<h1>Liste des utilisateurs</h1>

<table id="userList" name="userList" >
	  <tr>
	    <th>Prenom</th>
	    <th>Nom</th>
	    <th>Email</th>
	    <th>Supprimer</th>
	  </tr>
	<% 
		if (users != null && users.size() > 0){
			for(User u : users) {
				out.write("<tr><th>" + u.getUsr_firstname() + 
						"</th><th>" + u.getUsr_lastname() + 
						"</th><th>" + u.getUsr_email() +
						"</th><th><a  href=\"/user?action=delete&user=" + u.getUsr_id() + "\"> <input type=\"button\"  value=\"Supprimer\"></a>" +
						"</th></td>");
			}
		}
	%>
</table>

