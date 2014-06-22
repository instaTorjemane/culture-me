<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Formulaire de connexion</title>
	<link rel="stylesheet" type="text/css" href="css/style-login.css" />
	<script src="js/jquery.min.js"></script>
	<script src="js/cufon-yui.js" type="text/javascript"></script>	
	<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
	<script src="js/login.js" type="text/javascript"></script>	
	<script type="text/javascript">
		Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
		Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
		Cufon.replace('h3',{ textShadow: '1px 1px #000'});
		Cufon.replace('.back');
		
		$(function() {
			initLoginPage();			
		});
		
	</script>
</head>
<body>	
	<div class="wrapper">
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="register" action="RegisterUserServlet" method="post">
					<h3>Enregistrement</h3>
					<div class="column">
						<div>
							<label>Prénom</label>
							<input type="text" />
							<span class="error">Saisie invalide</span>
						</div>
						<div>
							<label>Nom</label>
							<input type="text" />
							<span class="error">Saisie invalide</span>
						</div>
						<div>
							<label>Site web</label>
							<input type="text" value="http://"/>
							<span class="error">Saisie invalide</span>
						</div>
					</div>
					<div class="column">
						<div>
							<label>Nom d'utilisateur</label>
							<input type="text"/>
							<span class="error">Saisie invalide</span>
						</div>
						<div>
							<label>Adresse mail</label>
							<input type="text" />
							<span class="error">Saisie invalide</span>
						</div>
						<div>
							<label>Mot de passe</label>
							<input type="password" />
							<span class="error">Saisie invalide</span>
						</div>
					</div>
					<div class="bottom">
						<input type="submit" value="Enregister" />
						<a href="login.jsp" rel="login" class="linkform">Vous avez déjà un compte? Connectez vous ici</a>
						<div class="clear"></div>
					</div>
				</form>
				<form class="login active" action="Login" method="post">
					<h3>Connexion</h3>
					<div>
						<label>Nom d'utilisateur</label>
						<input type="text" name="username"/>
						<span class="error">Saisie invalide</span>
					</div>
					<div>
						<label>Mot de passe<a href="login.jsp" rel="forgot_password" class="forgot linkform">Mot de passe oublié?</a></label>
						<input type="password" name="password"/>
						<span class="error">Saisie invalide</span>
					</div>
					<div class="bottom">
						<div class="remember"><input type="checkbox" /><span>Rester connecté</span></div>
						<input type="submit" value="Se connecter"></input>
						<a href="login.jsp" rel="register" class="linkform">Vous n'avez pas encore créé de compte? Enregistrez vous ici</a>
						<div class="clear"></div>
					</div>
				</form>
				<form class="forgot_password" action="SendPasswordServlet">
					<h3>Mot de passe perdu</h3>
					<div>
						<label>Nom d'utilisateur ou adresse mail</label>
						<input type="text" />
						<span class="error">Saisie invalide</span>
					</div>
					<div class="bottom">
						<input type="submit" value="Envoyer rappel"></input>
						<a href="login.jsp" rel="login" class="linkform">Votre mot de passe vous revient? Connectez vous ici</a>
						<a href="login.jsp" rel="register" class="linkform">Vous n'avez encore créé de compte? Enregistrez vous ici</a>
						<div class="clear"></div>
					</div>
				</form>
			</div>
			<div class="clear"></div>
		</div>			
	</div>
</body>
</html>  