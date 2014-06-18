package fr.upmc.aar.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.MovieDAO;
import fr.upmc.aar.dao.UserDAO;
import fr.upmc.aar.jtomato.JTomato;
import fr.upmc.aar.model.Movie;
import fr.upmc.aar.model.User;

public class PopulateServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creating a JTomato instance, you need a valid API key.
				JTomato jtomato = new JTomato("nmmu57pre35rzzvhbvdjetts");
				
				//setting the number of results per page. Default is 30.
				jtomato.setPage_limit(50);

				// Creating a list to store the results
				List<Movie> movies = new ArrayList<Movie>();

				movies = jtomato.getBoxOfficeMovies("us", 50);
				
				for (Movie movie : movies) {
					MovieDAO.addMovie(movie);
				}
	}


}
