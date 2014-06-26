<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="fr.upmc.aar.dao.CommentDAO"%>
<%@page import="fr.upmc.aar.model.Comment"%>
<%@page import="fr.upmc.aar.model.AbridgedCast"%>
<%@page import="fr.upmc.aar.model.User"%>
<%@page import="fr.upmc.aar.dao.MovieDAO"%>
<%@page import="fr.upmc.aar.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="fr.upmc.aar.utils.ApplicationHelper"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Culture-me</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />		
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-panels.min.js"></script>
		<script src="js/init.js"></script>
		
		<noscript>
			<link rel="stylesheet" href="css/skel-noscript.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
			<link rel="stylesheet" href="css/style-noscript.css" />			
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
		
		<script>
			$(document).ready(function() {                        
	            $("a[class='image featured small']").click(function(event) {
	            	event.preventDefault();
	            	$.ajax({
		                url: $(this).attr('href'),
		                type: "get",
		                data: $(this).serialize(),
		                success: function(results){
		                     $("#main").html(results);
		                } 
		            });
	            	return false;	                
	            });
	            
// 	            $("a[id='addComment']").click(function(event) {
// 	            	event.preventDefault();
// 	            	$.ajax({
// 		                url: $(this).attr('href'),
// 		                type: "get",
// 		                data: $(this).serialize(),
// 		                success: function(results){
// 		                     $("#comment").html(results);
// 		                } 
// 		            });
// 	            	return false;	                
// 	            });
	        }); 	            
        </script>
		
	</head>
	<body class="homepage">

		<!-- Header -->
			<div id="header">
						
				<!-- Inner -->
					<div class="inner">
						<header>
							<h1><a href="#" id="logo">Culture-me</a></h1>
							<hr />
							<span class="byline">Ne cherchez plus, retrouvez et discutez de tous vos films préférés au même endroit</span>
						</header>
						<footer>
							<a href="#banner" class="button circled scrolly">Découvrir</a>
						</footer>
					</div>
				
				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="welcome.jsp">Accueil</a></li>							
<!-- 							<li><a href="left-sidebar.html">Left Sidebar</a></li> -->
<!-- 							<li><a href="right-sidebar.html">Right Sidebar</a></li> -->
<!-- 							<li><a href="no-sidebar.html">No Sidebar</a></li> -->
							<%
								if (session.getAttribute("user") != null)
													{
														User connectedUser = (User) session.getAttribute("user");
														out.print("<li><a href='logout.jsp'>Se deconnecter (" + connectedUser.getFirstName() + " " + connectedUser.getLastName() + ")</a></li>");
													}
													else
														out.print("<li><a href='login.jsp'>Se connecter</a></li>");
							%>
<!-- 							<li><a href="login.jsp">Se connecter</a></li> -->
						</ul>
					</nav>					

			</div>
			
		<!-- Banner -->
			<div id="banner">
				<h2>Bienvenue dans le centre vidéoludique  <strong>Culture-me</strong>.</h2>
				<span class="byline">
					Ici, vous pouvez noter et commenter les films que vous avez visionnés et discuter de vos films 
					préférés avec les abonnés à travers une grande sélection que nous vous proposons.					
				</span>
			</div>
			
		<!-- Carousel Movies-->
			<div class="carousel">
				<div class="reel">

					<%
						List<Movie> movies = MovieDAO.listMovie();					
									String image = "";
										
									for (int i=0; i<movies.size(); i++)
									{
										String critics = movies.get(i).getCriticsConsensus();
										String title = movies.get(i).getTitle();
										String year = movies.get(i).getYear();
										
										if (critics == null) critics = "";
										if (title == null) title = "";
										
										if(movies.get(i).getPosters() != null)
										{
											try {
												image = movies.get(i).getPosters().getOriginal().replace("tmb.jpg", "ori.jpg");
											} catch (NullPointerException ex) {
												image = movies.get(i).getPosters().getOriginal();	
											}														
										}
										out.write(ApplicationHelper.createArticle("MovieDetailsServlet?title="+title+"&year="+year+"#main", 
											"image featured small", 
											image, 
											title,
											critics));
									}
					%>
				</div>
			</div>
			
		<!-- Main -->			
						
			<div class="wrapper style2">
				<article id="main" class="container special"></article>
			</div>			
		
			<%
									String focusTitle = request.getParameter("focusTitle");
										String focusYear = request.getParameter("focusYear");
										
										if (focusTitle != null && focusYear != null && session.getAttribute("user") != null)
										{
								%>
			<!-- Comment -->	
			<div class="wrapper style2">		
				<article id="comment" class="panel">
					<form action="AddCommentServlet?title=<%=focusTitle%>&year=<%=focusYear%>" method="post">
						<div>
							<div class="row half">										
								<div class="rating">
								    <input type="radio" name="rating" value="0" checked /><span id="hide"></span>
								    <input type="radio" name="rating" value="1" /><span></span>
								    <input type="radio" name="rating" value="2" /><span></span>
								    <input type="radio" name="rating" value="3" /><span></span>
								    <input type="radio" name="rating" value="4" /><span></span>
								    <input type="radio" name="rating" value="5" /><span></span>
								</div>
							</div>
							<div class="row half">
								<div class="12u">
									<textarea name="comment" placeholder="Commentaire"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="12u">
									<input type="submit" class="button" value="Soumettre" />
								</div>
							</div>
						</div>
					</form>
				</article>			
			</div>
			<%
				}
			%>
			
			<!-- Carousel My Comments-->
				<%
					if (session.getAttribute("user") != null)
							{
								User connectedUser = (User) session.getAttribute("user");
								List<Comment> comments = CommentDAO.userComments(connectedUser.getUsername());
								
								if(comments != null)
									if(comments.size()>0)
				%>
				<div class="carousel">
					<div class="reel">
						<header><h1>Tous mes commentaires </h1></header>
				<%
					for(Comment com : comments)
							out.write(ApplicationHelper.displayCommentArticle(com.getMovieTitle(), com.getContent(), com.getMark()));
				%>
					</div>
				</div>
				<%
					}
				%>
			
			<!-- Carousel All Movie Comments-->
				<%
					if (session.getAttribute("user") != null)
					{
						focusTitle = request.getParameter("commentTitle");
						focusYear = request.getParameter("commentYear");
						
						if (focusTitle != null && focusYear != null)
						{
								List<Comment> comments = MovieDAO.getMovieComments(focusTitle, focusYear);
								
								if(comments != null)
									if(!comments.isEmpty())
				%>
							<div class="carousel">
								<div class="reel">
									<header><h1>Tous les commentaires du film <%=focusTitle%></h1></header>
				<%
								for(Comment com : comments)
										out.write(ApplicationHelper.displayCommentArticle(com.getUsername(), com.getContent(), com.getMark()));
				%>
								</div>
							</div>
				<%
						}
					}
				%>

			

	</body>
</html>