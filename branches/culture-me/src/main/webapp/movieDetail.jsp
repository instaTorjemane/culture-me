<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="fr.upmc.aar.utils.HTMLHelper"%>
<%@page import="fr.upmc.aar.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="fr.upmc.aar.dao.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Culture-me </title>
	<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />		
	<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.dropotron.min.js"></script>
	<script src="js/skel.min.js"></script>
	<script src="js/skel-panels.min.js"></script>
	<script src="js/init.js"></script>
</head>
	<body>

		<!-- Header -->
				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="welcome.jsp">Accueil</a></li>							
							<li><a href="left-sidebar.html">Left Sidebar</a></li>
							<li><a href="right-sidebar.html">Right Sidebar</a></li>
							<li><a href="no-sidebar.html">No Sidebar</a></li>
							<li><a href="login.jsp">Se connecter</a></li>
						</ul>
					</nav>					

						
		<!-- Main -->
			<div class="wrapper style2">

				<article id="main" class="container special">
					<% 
						String movieTitle = request.getParameter("title");
						String movieYear = request.getParameter("year");
					
						if (!movieTitle.isEmpty() && !movieYear.isEmpty())
						{						
							Movie requestedMovie = MovieDAO.getMovie(movieTitle, movieYear);					
							
							String image = "";
							
							if(requestedMovie.getPosters() != null)
								image = requestedMovie.getPosters().getOriginal();
							
							String critics = requestedMovie.getCriticsConsensus();
							String title = requestedMovie.getTitle();
								
							if (critics == null) critics = "";
							if (title == null) title = "";						
								
							out.write(HTMLHelper.createArticle("movieDetail.jsp", 
								"image featured small", 
								image, 
								title,
								critics));
						}						
						else
						{}
							
					%>
					<a href="http://mdomaradzki.deviantart.com/art/Planet-Bronte-339258500" class="image featured"><img src="images/pic06.jpg" alt="" /></a>
					<header>
						<h2><a href="#"><%=movieTitle%></a></h2>
						<span class="byline">
							Sociis aenean eu aenean mollis mollis facilisis primis ornare penatibus aenean. Cursus ac enim 
							pulvinar curabitur morbi convallis. Lectus malesuada sed fermentum dolore amet.
						</span>
					</header>
					<p>
						Commodo id natoque malesuada sollicitudin elit suscipit. Curae suspendisse mauris posuere accumsan massa 
						posuere lacus convallis tellus interdum. Amet nullam fringilla nibh nulla convallis ut venenatis purus 
						sit arcu sociis. Nunc fermentum adipiscing tempor cursus nascetur adipiscing adipiscing. Primis aliquam 
						mus lacinia lobortis phasellus suscipit. Fermentum lobortis non tristique ante proin sociis accumsan 
						lobortis. Auctor etiam porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum 
						consequat integer interdum integer purus sapien. Nibh eleifend nulla nascetur pharetra commodo mi augue 
						interdum tellus. Ornare cursus augue feugiat sodales velit lorem. Semper elementum ullamcorper lacinia 
						natoque aenean scelerisque.
					</p>
					<footer>
						<a href="#" class="button">Continue Reading</a>
					</footer>
				</article>

			</div>

</body>
</html>