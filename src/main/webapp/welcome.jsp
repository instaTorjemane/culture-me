<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="fr.upmc.aar.model.AbridgedCast"%>
<%@page import="fr.upmc.aar.model.User"%>
<%@page import="fr.upmc.aar.dao.MovieDAO"%>
<%@page import="fr.upmc.aar.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="fr.upmc.aar.utils.HTMLHelper"%>

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
			
		<!-- Carousel -->
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
								image = movies.get(i).getPosters().getOriginal();
							
							
							out.write(HTMLHelper.createArticle("MovieDetailsServlet?title="+title+"&year="+year+"#main", 
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
			
 		<!-- Features -->
<!-- 			<div class="wrapper style1"> -->
				
<!-- 				<section id="features" class="container special"> -->
<!-- 					<header> -->
<!-- 						<h2>Morbi ullamcorper et varius leo lacus</h2> -->
<!-- 						<span class="byline">Ipsum volutpat consectetur orci metus consequat imperdiet duis integer semper magna.</span> -->
<!-- 					</header> -->
<!-- 					<div class="row"> -->
<!-- 						<article class="4u special"> -->
<!-- 							<a href="http://mdomaradzki.deviantart.com/art/Bueller-VII-351975126" class="image featured"><img src="images/pic07.jpg" alt="" /></a> -->
<!-- 							<header> -->
<!-- 								<h3><a href="#">Gravida aliquam penatibus</a></h3> -->
<!-- 							</header> -->
<!-- 							<p> -->
<!-- 								Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam -->
<!-- 								porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum. -->
<!-- 							</p> -->
<!-- 						</article> -->
<!-- 						<article class="4u special"> -->
<!-- 							<a href="http://mdomaradzki.deviantart.com/art/Home-Bound-Train-II-338912191" class="image featured"><img src="images/pic08.jpg" alt="" /></a> -->
<!-- 							<header> -->
<!-- 								<h3><a href="#">Sed quis rhoncus placerat</a></h3> -->
<!-- 							</header> -->
<!-- 							<p> -->
<!-- 								Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam -->
<!-- 								porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum. -->
<!-- 							</p> -->
<!-- 						</article> -->
<!-- 						<article class="4u special"> -->
<!-- 							<a href="http://mdomaradzki.deviantart.com/art/Up-is-Down-325005102" class="image featured"><img src="images/pic09.jpg" alt="" /></a> -->
<!-- 							<header> -->
<!-- 								<h3><a href="#">Magna laoreet et aliquam</a></h3> -->
<!-- 							</header> -->
<!-- 							<p> -->
<!-- 								Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam -->
<!-- 								porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum. -->
<!-- 							</p> -->
<!-- 						</article> -->
<!-- 					</div> -->
<!-- 				</section> -->

<!-- 			</div> -->

 		<!-- Footer -->
<!-- 			<div id="footer"> -->
<!-- 				<div class="container"> -->
<!-- 					<div class="row"> -->
						
<!-- 						Tweets -->
<!-- 							<section class="4u"> -->
<!-- 								<header> -->
<!-- 									<h2 class="fa fa-twitter circled solo"><span>Tweets</span></h2> -->
<!-- 								</header> -->
<!-- 								<ul class="divided"> -->
<!-- 									<li> -->
<!-- 										<article class="tweet"> -->
<!-- 											Amet nullam fringilla nibh nulla convallis tique ante sociis accumsan. -->
<!-- 											<span class="timestamp">5 minutes ago</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<article class="tweet"> -->
<!-- 											Hendrerit rutrum quisque. -->
<!-- 											<span class="timestamp">30 minutes ago</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<article class="tweet"> -->
<!-- 											Curabitur donec nulla massa laoreet nibh. Lorem praesent montes. -->
<!-- 											<span class="timestamp">3 hours ago</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<article class="tweet"> -->
<!-- 											Lacus natoque cras rhoncus curae dignissim ultricies. Convallis orci aliquet. -->
<!-- 											<span class="timestamp">5 hours ago</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</section> -->

<!-- 						Posts -->
<!-- 							<section class="4u"> -->
<!-- 								<header> -->
<!-- 									<h2 class="fa fa-file circled solo"><span>Posts</span></h2> -->
<!-- 								</header> -->
<!-- 								<ul class="divided"> -->
<!-- 									<li> -->
<!-- 										<article class="post stub"> -->
<!-- 											<header> -->
<!-- 												<h3><a href="#">Nisl fermentum integer</a></h3> -->
<!-- 											</header> -->
<!-- 											<span class="timestamp">3 hours ago</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<article class="post stub"> -->
<!-- 											<header> -->
<!-- 												<h3><a href="#">Phasellus portitor lorem</a></h3> -->
<!-- 											</header> -->
<!-- 											<span class="timestamp">6 hours ago</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<article class="post stub"> -->
<!-- 											<header> -->
<!-- 												<h3><a href="#">Magna tempus consequat</a></h3> -->
<!-- 											</header> -->
<!-- 											<span class="timestamp">Yesterday</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<article class="post stub"> -->
<!-- 											<header> -->
<!-- 												<h3><a href="#">Feugiat lorem ipsum</a></h3> -->
<!-- 											</header> -->
<!-- 											<span class="timestamp">2 days ago</span> -->
<!-- 										</article> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</section> -->

<!-- 						Photos -->
<!-- 							<section class="4u"> -->
<!-- 								<header> -->
<!-- 									<h2 class="fa fa-camera circled solo"><span>Photos</span></h2> -->
<!-- 								</header> -->
<!-- 								<div class="row quarter no-collapse"> -->
<!-- 									<div class="6u"> -->
<!-- 										<a href="http://mdomaradzki.deviantart.com/art/Air-Lounge-385212062" class="image full"><img src="images/pic10.jpg" alt="" /></a> -->
<!-- 									</div> -->
<!-- 									<div class="6u"> -->
<!-- 										<a href="http://mdomaradzki.deviantart.com/art/Paris-City-Streets-II-382623606" class="image full"><img src="images/pic11.jpg" alt="" /></a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="row quarter no-collapse"> -->
<!-- 									<div class="6u"> -->
<!-- 										<a href="http://mdomaradzki.deviantart.com/art/Trainride-Visions-383309985" class="image full"><img src="images/pic12.jpg" alt="" /></a> -->
<!-- 									</div> -->
<!-- 									<div class="6u"> -->
<!-- 										<a href="http://mdomaradzki.deviantart.com/art/Paris-Metro-382623851" class="image full"><img src="images/pic13.jpg" alt="" /></a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="row quarter no-collapse"> -->
<!-- 									<div class="6u"> -->
<!-- 										<a href="http://mdomaradzki.deviantart.com/art/Cliffs-of-Coogee-II-366961860" class="image full"><img src="images/pic14.jpg" alt="" /></a> -->
<!-- 									</div> -->
<!-- 									<div class="6u"> -->
<!-- 										<a href="http://mdomaradzki.deviantart.com/art/Stormy-Coast-VII-366561367" class="image full"><img src="images/pic15.jpg" alt="" /></a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</section> -->

<!-- 					</div> -->
<!-- 					<hr /> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="12u"> -->
							
<!-- 							Contact -->
<!-- 								<section class="contact"> -->
<!-- 									<header> -->
<!-- 										<h3>Nisl turpis nascetur interdum?</h3> -->
<!-- 									</header> -->
<!-- 									<p>Urna nisl non quis interdum mus ornare ridiculus egestas ridiculus lobortis vivamus tempor aliquet.</p> -->
<!-- 									<ul class="icons"> -->
<!-- 										<li><a href="#" class="fa fa-twitter solo"><span>Twitter</span></a></li> -->
<!-- 										<li><a href="#" class="fa fa-facebook solo"><span>Facebook</span></a></li> -->
<!-- 										<li><a href="#" class="fa fa-google-plus solo"><span>Google+</span></a></li> -->
<!-- 										<li><a href="#" class="fa fa-pinterest solo"><span>Pinterest</span></a></li> -->
<!-- 										<li><a href="#" class="fa fa-dribbble solo"><span>Dribbble</span></a></li> -->
<!-- 										<li><a href="#" class="fa fa-linkedin solo"><span>Linkedin</span></a></li> -->
<!-- 									</ul> -->
<!-- 								</section> -->
							
<!-- 							Copyright -->
<!-- 								<div class="copyright"> -->
<!-- 									<ul class="menu"> -->
<!-- 										<li>&copy; Untitled. All rights reserved.</li> -->
<!-- 										<li>Design: <a href="http://html5up.net/">HTML5 UP</a></li> -->
<!-- 									</ul> -->
<!-- 								</div> -->
							
<!-- 						</div> -->
					
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

	</body>
</html>