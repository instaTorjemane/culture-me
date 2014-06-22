package fr.upmc.aar.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.MovieDAO;
import fr.upmc.aar.model.Movie;

/**
 * Servlet implementation class MovieListServlet
 */
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Movie> movies = MovieDAO.listMovie();
		response.getWriter().print("<html> "+ "<body><h1>List des movies</h1>");
		
		for(Movie movie : movies){
			response.getWriter().print("<p>titre : " + movie.getTitle() + "</p>" + 
					"<p>Description : </p><p>" + movie.getSynopsis() +  "</p>" + 
					"<p>sortie : " + movie.getRuntime() + "</p>" 
					);
		}
		
		response.getWriter().print("</body>" + "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
