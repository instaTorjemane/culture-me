<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="fr.upmc.aar.model.User"%>
<%@page import="fr.upmc.aar.model.AbridgedCast"%>
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
		<div id="header">
				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="welcome.jsp">Accueil</a></li>							
							<li><a href="left-sidebar.html">Left Sidebar</a></li>
							<li><a href="right-sidebar.html">Right Sidebar</a></li>
							<li><a href="no-sidebar.html">No Sidebar</a></li>
							<% 
								if (session.getAttribute("user") != null)
								{
									User connectedUser = (User) session.getAttribute("user");
									out.print("<li><a href='logout.jsp'>Se deconnecter (" + connectedUser.getFirstName() + " " + connectedUser.getLastName() + ")</a></li>");
								}
								else
									out.print("<li><a href='login.jsp'>Se connecter</a></li>");
							%>
						</ul>
					</nav>					
		</div>
						
		<!-- Main -->
			<div class="wrapper style2">
				<article id="main" class="container special">
					<% 
						String movieTitle = request.getParameter("title");
						String movieYear = request.getParameter("year");
						String website = "";
						String critics = "";
						String title = "";
						String releaseDate = "";
						String runtime = "";
						String synopsis = "";
						List<String> genres = null;
						List<AbridgedCast> cast = null;
						String image = "";
						
						if (!movieTitle.isEmpty() && !movieYear.isEmpty())
						{						
							Movie requestedMovie = MovieDAO.getMovie(movieTitle, movieYear);					
							
							if (requestedMovie != null)
							{
								if(requestedMovie.getPosters() != null)
									image = requestedMovie.getPosters().getOriginal();
							
								critics = requestedMovie.getCriticsConsensus();
								title = requestedMovie.getTitle();
								releaseDate = requestedMovie.getReleaseDate().getTheater();
								runtime = requestedMovie.getRuntime();
								synopsis = requestedMovie.getSynopsis();
								genres = requestedMovie.getGenres();
								cast = requestedMovie.getAbridgedCast();								
								website = requestedMovie.getLinks().getAlternate();													
																	
							}
						}						
						else
						{}
							
					%>
					<a href="<%=website%>" target="_blank" class="image featured"><img src="<%=image%>" alt="" /></a>
					<header>
						<h2><a href="<%=website%>" target="_blank"><%=movieTitle%></a></h2>
						<span class="byline">
							<%=synopsis%>
						</span>
					</header>
					<p>
						<div class="runtime">
							<h3>Durée</h3>
							<%=runtime%>
						</div>					
						<% 
							if (!critics.isEmpty())
								out.print("<div class='critics'><h3>Critiques</h3>" + critics + "</div>");								
						%>
						<div class="casting">
							<header><h3>Casting</h3></header>
							<%
								out.print("<ul>");
								for (AbridgedCast actor : cast)
									out.print("<li class='actor'>" + actor.getName() + "</li>");
								out.print("</ul>");
							%>
						</div>						
					</p>
					<footer>
						<a href="#" class="button">Continue Reading</a>
					</footer>
				</article>

			</div>

</body>
</html>