package fr.upmc.aar.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.MovieDAO;
import fr.upmc.aar.model.Comment;
import fr.upmc.aar.model.Movie;
import fr.upmc.aar.model.User;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
		//List<Movie> movies = MovieDAO.listMovie();
		String movieTitle = request.getParameter("title");
		String movieYear = request.getParameter("year");
		String userComment = request.getParameter("comment");
		double userMark = Float.valueOf(request.getParameter("rating"));
		User connectedUser = (User) request.getSession().getAttribute("user");

		if(movieTitle != null && movieYear != null)
			if (!movieTitle.isEmpty() && !movieYear.isEmpty())
			{
				Movie movie = MovieDAO.getMovie(movieTitle,movieYear);
				
				Comment comment = new Comment();
				comment.setCommentDate(new Date());
				comment.setContent(userComment);
				comment.setMark(userMark);
				comment.setUsername(connectedUser.getUsername());
				comment.setMovieTitle(movie.getTitle());
				comment.setMovieYear(movie.getYear());
				
				MovieDAO.addCommentToMovie(comment);
//				System.out.println("Commentaire bien ajouté");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp"); 
				dispatcher.forward(request, response);			
			}				
	}

}
