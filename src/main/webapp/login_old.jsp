<h3>Connexion</h3>

<form method="post" action="Login">
<label>Login :</label><br/> 
<input value="" type="text" name="login" /><br />
<label>Mot de passe :</label><br />
<input value="" type="password" name="password" /> 
<input type="submit" value="Connect" />
</form>

<span><a href="UserServlet?action=toForm">Pas encore inscrit?</a></span>
<% if(request.getSession().getAttribute("auth") == "false") { %>
<span class="erreur">Erreur de login et/ou de password</span>
<% }%>
<br />