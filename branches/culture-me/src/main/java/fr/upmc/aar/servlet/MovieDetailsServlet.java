package fr.upmc.aar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.MovieDAO;
import fr.upmc.aar.model.AbridgedCast;
import fr.upmc.aar.model.Comment;
import fr.upmc.aar.model.Movie;
import fr.upmc.aar.model.User;

/**
 * Servlet implementation class MovieDetailsServlet
 */
public class MovieDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String movieTitle = request.getParameter("title");
		String movieYear = request.getParameter("year");
		String website = "";
		String critics = "";
		String title = "";
		String releaseDate = "";
		String runtime = "";
		String synopsis = "";
		//List<String> genres = null;
		List<AbridgedCast> cast = null;
		String image = "";
		
		if (movieTitle == null || movieYear == null)
		{
			movieTitle = request.getParameter("focusTitle");
			movieYear = request.getParameter("focusYear");
		}
		
		if (movieTitle != null && movieYear != null)
		{	
			if (!movieTitle.isEmpty() && !movieYear.isEmpty())
			{		 
				Movie requestedMovie = MovieDAO.getMovie(movieTitle, movieYear);					
			
				if (requestedMovie != null)
				{
					if(requestedMovie.getPosters() != null)
					{	
						try {
							image = requestedMovie.getPosters().getOriginal().replace("tmb.jpg", "ori.jpg");
						} catch (NullPointerException ex) {
							image = requestedMovie.getPosters().getOriginal();
						}
					}
					critics = requestedMovie.getCriticsConsensus();
					title = requestedMovie.getTitle();
					releaseDate = requestedMovie.getReleaseDate().getTheater();
					runtime = requestedMovie.getRuntime();
					synopsis = requestedMovie.getSynopsis();
					//genres = requestedMovie.getGenres();
					cast = requestedMovie.getAbridgedCast();								
					website = requestedMovie.getLinks().getAlternate();													
																		
				}

				out.print("<a href='" + website + "' target='_blank' class='image featured'><img src='" + image + "' alt='' /></a>");
				out.print("<header><h2><a href='" + website + "' target='_blank'>" + movieTitle + "</a></h2>");
				out.print("<span class='byline'>" + synopsis + "</span></header>");
				out.print("<p><div class='runtime'><h3>Dur&eacute;e</h3>" + runtime + "</div>");
				
				if (critics != null)
					if (!critics.isEmpty())
						out.print("<div class='critics'><h3>Critiques</h3>" + critics + "</div>");
				
				if (cast != null)
					if (cast.size() > 0)
					{					
						out.print("<div class='casting'><h3>Casting</h3><ul>");
						for (AbridgedCast actor : cast)
							out.print("<li class='actor'>" + actor.getName() + "</li>");
						out.print("</ul></div></p>");
					}
				
				User currentUser = (User) request.getSession().getAttribute("user"); 
				if (currentUser != null)
				{
					out.print("<footer><a href='welcome.jsp?commentTitle=" + movieTitle + "&commentYear=" + movieYear + "' class='button'>Tous les commentaires sur ce film</a></footer>");
					List<Comment> comments = MovieDAO.getMovieComments(movieTitle,movieYear);
					if(comments == null)
						out.print("<footer><a href='welcome.jsp?focusTitle=" + movieTitle + "&focusYear=" + movieYear + "#comment' class='button' id='addComment'>Laisser un commentaire</a></footer>");
				}
					 	
			}
		}						
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
