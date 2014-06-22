<%@page import="fr.upmc.aar.model.User" %>
<h3>Connexion</h3>
<span><p>Bienvenue 
<% 
	User u= (User)request.getSession().getAttribute("user");
	out.println(" "+u.getFirstName()+" "+u.getLastName());
%>
</p></span>
<span><a href="logout.jsp">Se deconnecter</a></span>
<br />
<span><a href="UserComments">Voir mes commentaires</a></span>